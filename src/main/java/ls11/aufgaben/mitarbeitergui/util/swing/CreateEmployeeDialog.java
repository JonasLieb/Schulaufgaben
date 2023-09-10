package ls11.aufgaben.mitarbeitergui.util.swing;


import ls11.aufgaben.mitarbeitergui.VerwaltungsGUI;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.Employee;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public final class CreateEmployeeDialog {

    private CreateEmployeeDialog() {
    }

    public static void showCreateEmployeePane(VerwaltungsGUI parent, Class<? extends Employee>[] validTypes) {
        JTabbedPane pane = new JTabbedPane();
        for (Class<?> clazz : validTypes) {
            addCreatingEmployeeTab(pane, clazz);
        }

        JDialog dialog = new JDialog(parent, "Mitarbeiter erstellen");
        dialog.add(pane);
        dialog.setModal(true);
        dialog.setVisible(true);
    }

    private static void addCreatingEmployeeTab(JTabbedPane pane, Class<?> clazz) {
        if (pane == null) return;
        //Ersten Konstruktor mit Annotation "EmployeeDialogCreatable"
        Constructor<?> c = Arrays.stream(clazz.getConstructors()).filter(constructor -> {
            Annotation[] annotations = constructor.getAnnotations();
            for (Annotation annotation : annotations) if (annotation instanceof EmployeeDialogCreatable) return true;
            return false;
        }).findFirst().orElse(null);
        if(c == null)return;

        JPanel panel = new JPanel();
        Parameter[] parametersToFill = c.getParameters();
        for(Parameter p : parametersToFill){
            panel.add(getParameterPanel(p));
        }

        pane.add(clazz.getName(), panel);
    }

    private static JPanel getParameterPanel(Parameter p){
        if(p == null)return null;
        JPanel panel = new JPanel(new GridLayout(1,0));
        panel.add(new ParameterPanel(p));
        return panel;
    }
}
