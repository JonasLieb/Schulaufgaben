package ls11.aufgaben.mitarbeitergui.util.swing;


import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.EmployeeUtils;
import ls11.aufgaben.mitarbeitergui.util.annotations.ParameterName;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable<T extends Employee> extends JTable {
    private final List<T> currentEmployeeList = new ArrayList<>();
    private Class<T> persistentClass;

    public EmployeeTable(Class<T> clazz) {
        persistentClass = clazz;
        initGUI();
    }

    private void initGUI() {
        Field[] declaredFields = EmployeeUtils.getNonConstantEmployeeFields(persistentClass);

        String[] headers = new String[declaredFields.length];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = declaredFields[i].getAnnotation(ParameterName.class).name();
        }

        this.setModel(getUneditableTableModel(null, headers));
        update();
    }

    private void update() {
        final DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.setRowCount(0); //Remove all

        Field[] declaredFields = EmployeeUtils.getNonConstantEmployeeFields(persistentClass);

        currentEmployeeList.stream().map(empl -> {
            Object[] rowData = new Object[declaredFields.length];
            for (int col = 0; col < rowData.length; col++) {
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
        revalidate();
    }

    public void setData(List<T> employees) {
        currentEmployeeList.clear();
        currentEmployeeList.addAll(employees);
        update();
    }

    public Employee[] getSelectedEmployees() {
        int[] selectedRows = getSelectedRows();
        Employee[] empls = new Employee[selectedRows.length];

        int columnIndex = getColumn("ID").getModelIndex();

        for(int i = 0; i < selectedRows.length; i++){
            empls[i] = getEmployeeByID(String.valueOf(getValueAt(selectedRows[i], columnIndex))); //Achtung! ID muss eindeutig sein!
        }
        return empls;
    }

    private Employee getEmployeeByID(String id) {
        return currentEmployeeList.stream().filter(e -> String.valueOf(e.getId()).equalsIgnoreCase(id)).findFirst().orElse(null);
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