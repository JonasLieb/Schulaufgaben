package ls11.mitarbeitergui;

import com.formdev.flatlaf.FlatDarkLaf;
import ls07.aufgaben.mitarbeiter_csv.employee.Employee;
import ls07.aufgaben.mitarbeiter_csv.employee.Manager;
import ls07.aufgaben.mitarbeiter_csv.employee.ShiftWorker;
import ls07.aufgaben.mitarbeiter_csv.util.EmployeeTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerwaltungsGUI extends JFrame {
    private final List<Employee> employees = new ArrayList<Employee>();
    private EmployeeTable<Employee> allEmployeesTable;
    private EmployeeTable<ShiftWorker> allShiftWorkersTable;


    public static void main(String[] args) {
        VerwaltungsGUI gui = new VerwaltungsGUI();
        gui.setVisible(true);
    }

    public VerwaltungsGUI() {
        FlatDarkLaf.setup();
        initGUI();
        pack();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getManagePanel(), BorderLayout.WEST);
        mainPanel.add(getVisualizeEmployeesPanel(), BorderLayout.CENTER);

        this.add(mainPanel);
        this.setMinimumSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel getManagePanel() {
        JPanel managePanel = new JPanel(new GridLayout(0, 1, 5, 5));

        JButton addEmployeeButton = new JButton("+");
        addEmployeeButton.setBackground(Color.GREEN);
        addEmployeeButton.addActionListener(a -> addEmployee());
        managePanel.add(addEmployeeButton);

        JButton removeSelectedEmployeeButton = new JButton("-");
        removeSelectedEmployeeButton.setBackground(Color.RED);
        removeSelectedEmployeeButton.addActionListener(a -> removeSelectedEmployee());
        managePanel.add(removeSelectedEmployeeButton);


        JButton saveEmployeesButton = new JButton("Save in CSV");
        saveEmployeesButton.setBackground(new Color(112, 88, 88));
        saveEmployeesButton.addActionListener(a -> removeSelectedEmployee());
        managePanel.add(saveEmployeesButton);

        JButton loadEmployeesButton = new JButton("Read from CSV");
        loadEmployeesButton.setBackground(new Color(112, 88, 88));
        loadEmployeesButton.addActionListener(a -> removeSelectedEmployee());
        managePanel.add(loadEmployeesButton);

        return managePanel;
    }

    private JTabbedPane getVisualizeEmployeesPanel() {
        JTabbedPane tabbedPane = new JTabbedPane();

        allEmployeesTable = new EmployeeTable<>(Employee.class);
        allEmployeesTable.setData(employees);

        allShiftWorkersTable = new EmployeeTable<>(ShiftWorker.class);
        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        employees.stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);
        allShiftWorkersTable.setData(shiftWorkers);

        //TODO

        tabbedPane.addTab("Mitarbeiter", allEmployeesTable);
        tabbedPane.addTab("Schichtarbeiter", allShiftWorkersTable);
        return tabbedPane;
    }

    private void addEmployee() {
        //TODO
        System.out.println("Todo...");

        Manager m = new Manager("Peter", 5001, 5000, .05);
        ShiftWorker w = new ShiftWorker("Shifto", 3001, 20);
        employees.add(m);
        employees.add(w);


        updateGUI();
    }


    private void removeSelectedEmployee() {
        System.out.println("Not implemented Yet...");
    }

    private void updateGUI() {
        allEmployeesTable.setData(employees);

        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        employees.stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);

        allShiftWorkersTable.setData(shiftWorkers);
//        management.getEmployees().stream().map(e -> new String[]{String.valueOf(e.getId()), e.getName()}).forEach(allEmployeesModel::addRow);
//        management.getShiftWorkers().stream().map(e -> new String[]{String.valueOf(e.getId()), e.getName(), String.valueOf(e.income())}).forEach(allShiftWorkersModel::addRow);

        revalidate();
    }

}
