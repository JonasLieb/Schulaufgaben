package ls11.aufgaben.mitarbeitergui.util.swing;


import ls11.aufgaben.mitarbeitergui.VerwaltungsGUI;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.Employee;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CreateEmployeeDialog {
    private static JDialog dialog;
    private static VerwaltungsGUI p;

    private CreateEmployeeDialog() {
    }

    public static void showCreateEmployeePane(VerwaltungsGUI parent, Class<? extends Employee>[] validTypes) {
        p = parent;
        JTabbedPane pane = new JTabbedPane();
        for (Class<?> clazz : validTypes) {
            addCreatingEmployeeTab(pane, clazz);
        }
        dialog = new JDialog(parent, "Mitarbeiter erstellen");
        dialog.add(pane);
        dialog.setModal(true);
        dialog.setMinimumSize(new Dimension(300,100));
        dialog.pack();
        dialog.setVisible(true);
    }

    private static void addCreatingEmployeeTab(JTabbedPane pane, Class<?> clazz) {
        if (pane == null) return;
        //Ersten Konstruktor mit Annotation "EmployeeDialogCreatable"

        Constructor<?> constructor = Arrays.stream(clazz.getConstructors()).filter(c -> {
            Annotation[] annotations = c.getAnnotations();
            for (Annotation annotation : annotations) if (annotation instanceof EmployeeDialogCreatable) return true;
            return false;
        }).findFirst().orElse(null);
        if (constructor == null) return;

        JPanel panel = new JPanel(new GridLayout(0,1));
        Parameter[] parametersToFill = constructor.getParameters();
        String[] names = constructor.getAnnotation(EmployeeDialogCreatable.class).parameterNames();
        for (int i = 0; i < parametersToFill.length; i++) {
            String name;
            if (i >= names.length) name = "";
            else name = names[i];
            Parameter p = parametersToFill[i];
            panel.add(new ParameterPanel(name, p));
        }
        
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton createEmployeeButton = new JButton("Erstellen");
        createEmployeeButton.addActionListener(a -> {
            List<ParameterPanel> panels = Arrays.stream(panel.getComponents()).filter(c -> c instanceof ParameterPanel).map(pPanel -> (ParameterPanel)pPanel).collect(Collectors.toList());
            Object[] parms = new Object[panels.size()];
            for (int i = 0; i< panels.size(); i++) {
                parms[i] = panels.get(i).getValue();
            }
            try {
                p.addEmployee((Employee) constructor.newInstance(parms));
            }catch(Exception e){
                JOptionPane.showConfirmDialog(dialog, e.getMessage(), "Fehler", JOptionPane.DEFAULT_OPTION);
            }
        });
        buttonPanel.add(createEmployeeButton);
        panel.add(buttonPanel);

        pane.add(getClassNameOnly(clazz.getName()), panel);
    }

    private static String getClassNameOnly(String nameWithPath){
        if(nameWithPath == null ||nameWithPath.isEmpty())return nameWithPath;

        return nameWithPath.substring(nameWithPath.lastIndexOf(".") + 1);
    }
}
