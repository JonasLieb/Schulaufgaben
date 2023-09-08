package ls07.aufgaben.mitarbeiter_csv.util;

import ls07.aufgaben.mitarbeiter_csv.employee.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeTable<T extends Employee> extends JTable {
    private final List<T> currentEmployeeList = new ArrayList<>();
    private Class<T> persistentClass;

    public EmployeeTable(Class<T> clazz) {
        persistentClass = clazz;
        initGUI();
    }

    private void initGUI() {
        Field[] declaredFields = persistentClass.getDeclaredFields();
        String[] headers = new String[declaredFields.length];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = declaredFields[i].getName();
        }

        this.setModel(getUneditableTableModel(null, headers));
        update();
    }

    private void update() {
        this.removeAll();
        final DefaultTableModel model = (DefaultTableModel) this.getModel();


        Field[] declaredFields = persistentClass.getDeclaredFields();
        Object[][] data = new Object[currentEmployeeList.size()][];

        currentEmployeeList.stream().map(empl -> {
            Object[] rowData = new Object[declaredFields.length];
            for(int col = 0; col < rowData.length; col++){
                declaredFields[col].setAccessible(true);
                Object value;
                try {
                    value = declaredFields[col].get(empl);
                } catch (IllegalAccessException e) {
                    value = "/";
                }
                rowData[col] = value;
            }
            return rowData;
        }).forEach(model::addRow);

//        for (int i = 0; i < currentEmployeeList.size(); i++) {
//            Object[] arr = new Object[declaredFields.length];
//            for (int j = 0; j < arr.length; j++) {
//                T t = currentEmployeeList.get(j);
//                declaredFields[j].setAccessible(true);
//                Object value;
//                try {
//                    value = declaredFields[j].get(t);
//                } catch (IllegalAccessException e) {
//                    value = "/";
//                }
//                arr[j] = value;
//            }
//            data[i] = arr;
//        }
//
//        Arrays.stream(data).forEach(model::addRow);
        revalidate();
    }

    public void setData(List<T> employees) {
        currentEmployeeList.clear();
        currentEmployeeList.addAll(employees);
        update();
    }

    public void addEmployee(T employee) {
        currentEmployeeList.add(employee);
        update();
    }

    public void removeEmployee(T employee) {
        currentEmployeeList.remove(employee);
        update();
    }

    private static DefaultTableModel getUneditableTableModel(Object[][] data, String[] columnNames) {
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}