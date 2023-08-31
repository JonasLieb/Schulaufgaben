package ls11.mitarbeitergui;

import com.formdev.flatlaf.FlatDarkLaf;
import ls07.aufgaben.mitarbeiter_csv.BusinessManagement;
import ls07.aufgaben.mitarbeiter_csv.Departement;
import ls07.aufgaben.mitarbeiter_csv.employee.Employee;
import ls07.aufgaben.mitarbeiter_csv.employee.Manager;
import ls07.aufgaben.mitarbeiter_csv.employee.ShiftWorker;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class VerwaltungsGUI extends JFrame {

    private JTable allEmployeesTable;
    private JTable allShiftWorkersTable;
    private final BusinessManagement management;

    public static void main(String[] args) {
        VerwaltungsGUI gui = new VerwaltungsGUI(new BusinessManagement());
        gui.setVisible(true);
    }

    public VerwaltungsGUI(BusinessManagement management) {
        FlatDarkLaf.setup();
        this.management = management;
        initGUI();
        pack();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getManagePanel(), BorderLayout.WEST);
        mainPanel.add(getVisualizeEmployeesPanel(), BorderLayout.EAST);

        this.add(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel getManagePanel() {
        JPanel managePanel = new JPanel(new BorderLayout());

        JButton addEmployeeButton = new JButton("+");
        addEmployeeButton.addActionListener(a -> addEmployee());
        managePanel.add(addEmployeeButton, BorderLayout.CENTER);

        return managePanel;
    }

    private JTabbedPane getVisualizeEmployeesPanel() {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel allEmployeesPanel = new JPanel();
        DefaultTableModel allEmployeesModel = getUneditableTableModel();
        allEmployeesModel.addColumn("ID");
        allEmployeesModel.addColumn("Name");
        allEmployeesTable = new JTable(allEmployeesModel);
        allEmployeesPanel.add(allEmployeesTable);

        JPanel allShiftWorkersPanel = new JPanel();
        DefaultTableModel allShiftWorkersModel = getUneditableTableModel();
        allEmployeesModel.addColumn("ID");
        allEmployeesModel.addColumn("Name");
        allEmployeesModel.addColumn("Monatsentgehalt");
        allShiftWorkersTable = new JTable(allShiftWorkersModel);
        allShiftWorkersPanel.add(allShiftWorkersTable);


        tabbedPane.addTab("Mitarbeiter", allEmployeesPanel);
        tabbedPane.addTab("Schichtarbeiter", allShiftWorkersPanel);
        return tabbedPane;
    }

    private void addEmployee() {
        System.out.println("Todo...");

        Manager m = new Manager("Peter", 5001, 5000, .05);
        ShiftWorker w = new ShiftWorker("Shifto", 3001, 20);
        Departement dep = new Departement("Test", new Manager("Tester", 5002, 5000, .05));
        management.addEmployee(m, dep);
        management.addEmployee(w, dep);

        updateGUI();
    }

    private void updateGUI() {
        allEmployeesTable.removeAll();
        allShiftWorkersTable.removeAll();
        final DefaultTableModel allEmployeesModel = (DefaultTableModel) allEmployeesTable.getModel();
        final DefaultTableModel allShiftWorkersModel = (DefaultTableModel) allShiftWorkersTable.getModel();

        management.getEmployees().stream().map(e -> new String[]{String.valueOf(e.getId()), e.getName()}).forEach(allEmployeesModel::addRow);
        management.getShiftWorkers().stream().map(e -> new String[]{String.valueOf(e.getId()), e.getName(), String.valueOf(e.income())}).forEach(allShiftWorkersModel::addRow);

        revalidate();
    }


    private static DefaultTableModel getUneditableTableModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
