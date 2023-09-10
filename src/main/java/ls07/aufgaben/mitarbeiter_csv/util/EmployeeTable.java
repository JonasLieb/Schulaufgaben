package ls07.aufgaben.mitarbeiter_csv.util;

import ls07.aufgaben.mitarbeiter_csv.employee.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
        Field[] declaredFields = getNonConstantEmployeeFields(persistentClass);

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

        Field[] declaredFields = getNonConstantEmployeeFields(persistentClass);

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

    private static Field[] getNonConstantEmployeeFields(Class<?> persistentClass) {
        return getNonConstantEmployeeFieldsRecursiv(persistentClass);
    }

    private static Field[] getNonConstantEmployeeFieldsRecursiv(Class<?> currentClass){
        //1. bin ich noch eine passende Klasse? Falls nein return
        if(! Employee.class.isAssignableFrom(currentClass)) return null;

        //2. Ich bin eine passende Klasse -> Felder der höheren Klassen holen, meine anhängen
        Class<?> parent = currentClass.getSuperclass();
        Field[] additionalFields = (parent == null) ? null : getNonConstantEmployeeFieldsRecursiv(parent);
        Field[] myFields = Arrays.stream(currentClass.getDeclaredFields()).filter(EmployeeTable::isNotStaticFinal).toArray(Field[]::new);
        return concatenate(additionalFields, myFields);
    }

    private static <T> T[] concatenate(T[] a, T[] b) {
        if(a == null && b == null)return null;
        else if(a == null) return b;
        else if(b == null) return a;

        int aLen = a.length;
        int bLen = b.length;
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    private static boolean isNotStaticFinal(Field field) {
        return !isStaticFinal(field);
    }

    private static boolean isStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isStatic(modifiers) && Modifier
                .isFinal(modifiers));
    }
}