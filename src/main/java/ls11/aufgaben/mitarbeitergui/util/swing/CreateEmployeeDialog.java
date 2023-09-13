package ls11.aufgaben.mitarbeitergui.util.swing;


import ls11.aufgaben.mitarbeitergui.VerwaltungsGUI;
import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.annotations.ClassNameUtils;
import ls11.aufgaben.mitarbeitergui.util.annotations.EmployeeDialogCreatable;
import ls11.aufgaben.mitarbeitergui.util.annotations.EmployeeDialogCreatableUtils;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CreateEmployeeDialog extends JDialog {
    private static final String TITLE_TEXT = "Mitarbeiter erstellen";
    private final VerwaltungsGUI verwaltungsGUI;
    private final List<ParameterPanel> allPanels = new ArrayList<>();

    public  CreateEmployeeDialog(VerwaltungsGUI parent, Class<? extends Employee>[] validTypes) {
        verwaltungsGUI = parent;
        JTabbedPane pane = new JTabbedPane();
        for (Class<?> clazz : validTypes) {
            addCreatingEmployeeTab(pane, clazz);
        }
        this.setTitle(TITLE_TEXT);
        this.add(pane);
        this.setModal(true);
        this.setMinimumSize(new Dimension(350, 200));
        this.pack();
    }

    private VerwaltungsGUI getVerwaltungsGUI() {
        return verwaltungsGUI;
    }

    /**
     * Adds one tab to the JTabbedPane based on clazz
     *
     * @param pane  the JTabbedPane that will be configured
     * @param clazz the class that should be represented by the new tab
     */
    private void addCreatingEmployeeTab(JTabbedPane pane, Class<?> clazz) {
        if (pane == null) return;

        //Ersten Konstruktor mit Annotation "EmployeeDialogCreatable" ermitteln:
        Constructor<?> constructor = EmployeeDialogCreatableUtils.getFirstConstructorWithAnnotation(clazz);

        //Neues JPanel erstellen und dieses mit den einzelnen "ParameterPanel"-Komponenten füllen
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Parameter[] parametersToFill = constructor.getParameters();
        String[] names = constructor.getAnnotation(EmployeeDialogCreatable.class).parameterNames();
        for (int i = 0; i < parametersToFill.length; i++) {
            ParameterPanel paramPanel = new ParameterPanel((i >= names.length) ? "" : names[i], parametersToFill[i]);
            panel.add(paramPanel);
            allPanels.add(paramPanel);
        }

        //Button erstellen und hinzufügen
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton createEmployeeButton = new JButton("Erstellen");
        createEmployeeButton.addActionListener(a -> {
            List<ParameterPanel> panels = Arrays.stream(panel.getComponents()).filter(c -> c instanceof ParameterPanel).map(pPanel -> (ParameterPanel) pPanel).collect(Collectors.toList());
            Object[] parms = new Object[panels.size()];
            for (int i = 0; i < panels.size(); i++) {
                parms[i] = panels.get(i).getValue();
            }
            try {
                verwaltungsGUI.addEmployee((Employee) constructor.newInstance(parms));
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(pane, e.getMessage(), "Fehler", JOptionPane.DEFAULT_OPTION);
            }
            CreateEmployeeDialog.this.setVisible(false);
        });
        buttonPanel.add(createEmployeeButton);
        panel.add(buttonPanel);

        //Tab hinzufügen
        pane.add(ClassNameUtils.getClassNameOnly(clazz), panel);
    }

    public void setVisible(boolean b){
        if(b && !isVisible()){
            reset();
        }
        super.setVisible(b);
    }

    private void reset() {
        if(allPanels == null)return;
        allPanels.forEach(ParameterPanel::clearInput);
    }
}
