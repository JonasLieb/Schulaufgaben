package ls11.aufgaben.mitarbeitergui;

import com.formdev.flatlaf.FlatDarkLaf;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.Manager;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.OfficeWorker;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee.ShiftWorker;
import ls11.aufgaben.mitarbeitergui.util.swing.CreateEmployeeDialog;
import ls11.aufgaben.mitarbeitergui.util.swing.EmployeeTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VerwaltungsGUI extends JFrame {

    private static final String TITLE = "Mitarbeiterverwaltung";
    private static final Class<? extends Employee>[] VALID_EMPLOYEES = (Class<? extends Employee>[]) new Class<?>[]{ShiftWorker.class, Manager.class, OfficeWorker.class};

    private EmployeeManagement management = new EmployeeManagement();
    private EmployeeTable<Employee> allEmployeesTable;
    private EmployeeTable<ShiftWorker> allShiftWorkersTable;

    public static void main(String[] args) {
        VerwaltungsGUI gui = new VerwaltungsGUI();
        gui.setVisible(true);
    }

    public VerwaltungsGUI() {
        this(new EmployeeManagement());
    }

    public VerwaltungsGUI(EmployeeManagement management) {
        FlatDarkLaf.setup();
        setManagement(management);
        initGUI();
        pack();
    }

    private void setManagement(EmployeeManagement management) {
        if (management == null) this.management = new EmployeeManagement();
        else this.management = management;
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getManagePanel(), BorderLayout.WEST);
        mainPanel.add(getVisualizeEmployeesPanel(), BorderLayout.CENTER);

        this.add(mainPanel);
        this.setMinimumSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(TITLE);
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
        allEmployeesTable.setData(management.getEmployees());

        allShiftWorkersTable = new EmployeeTable<>(ShiftWorker.class);
        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);
        allShiftWorkersTable.setData(shiftWorkers);

        tabbedPane.addTab("Mitarbeiter", new JScrollPane(allEmployeesTable));
        tabbedPane.addTab("Schichtarbeiter", new JScrollPane(allShiftWorkersTable));
        return tabbedPane;
    }

    private void addEmployee() {
        CreateEmployeeDialog.showCreateEmployeePane(this, VALID_EMPLOYEES);
    }

    public void addEmployee(Employee e) {
        management.addEmployee(e);
        updateGUI();
    }


    private void removeSelectedEmployee() {
        System.out.println("Not implemented Yet...");
    }

    private void updateGUI() {
        allEmployeesTable.setData(management.getEmployees());

        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);
        allShiftWorkersTable.setData(shiftWorkers);

        revalidate();
    }

}
