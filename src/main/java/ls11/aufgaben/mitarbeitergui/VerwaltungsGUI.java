package ls11.aufgaben.mitarbeitergui;

import com.formdev.flatlaf.FlatDarkLaf;
import ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.employee.*;
import ls11.aufgaben.mitarbeitergui.util.swing.CreateEmployeeDialog;
import ls11.aufgaben.mitarbeitergui.util.swing.EmployeeTable;
import ls11.aufgaben.mitarbeitergui.util.swing.ImageHandler;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerwaltungsGUI extends JFrame {

    private static final String TITLE = "Mitarbeiterverwaltung";
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String CSV_FILE_NAME = "employeeData.csv";
    private static final Class<? extends Employee>[] VALID_EMPLOYEES = (Class<? extends Employee>[]) new Class<?>[]{
            OfficeWorker.class,
            Manager.class,
            ShiftWorker.class,
            Driver.class
    };
    private EmployeeManagement management = new EmployeeManagement();
    private EmployeeTable<Employee> allEmployeesTable;
    private EmployeeTable<Manager> allManagersTable;
    private EmployeeTable<OfficeWorker> allOfficeWorkersTable;
    private EmployeeTable<ShiftWorker> allShiftWorkersTable;
    private EmployeeTable<Driver> allDriversTable;
    private final CreateEmployeeDialog createEmployeeDialog;
    private JButton saveEmployeesButton;
    private JButton loadEmployeesButton;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        VerwaltungsGUI gui = new VerwaltungsGUI();
        gui.setVisible(true);
    }

    public VerwaltungsGUI() {
        this(new EmployeeManagement());
    }

    public VerwaltungsGUI(EmployeeManagement management) {
        FlatDarkLaf.setup();

        createEmployeeDialog = new CreateEmployeeDialog(this, VALID_EMPLOYEES);

        setManagement(management);
        setIconImage(ImageHandler.getInstance().getImage("HumanResources.png"));
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

        JButton addEmployeeButton = new JButton();
        addEmployeeButton.setToolTipText("Mitarbeiter hinzufügen");
        addEmployeeButton.setIcon(ImageHandler.getInstance().getIcon("AddEmployee.png"));
        addEmployeeButton.setBackground(new Color(5, 109, 5));
        addEmployeeButton.addActionListener(a -> addEmployee());
        managePanel.add(addEmployeeButton);

        JButton removeSelectedEmployeeButton = new JButton();
        removeSelectedEmployeeButton.setToolTipText("Ausgewählte Mitarbeiter entfernen");
        removeSelectedEmployeeButton.setIcon(ImageHandler.getInstance().getIcon("RemoveEmployee.png"));
        removeSelectedEmployeeButton.setBackground(new Color(141, 1, 25));
        removeSelectedEmployeeButton.addActionListener(a -> removeSelectedEmployee());
        managePanel.add(removeSelectedEmployeeButton);


        saveEmployeesButton = new JButton();
        saveEmployeesButton.setToolTipText("In CSV-Datei speichern");
        saveEmployeesButton.setIcon(ImageHandler.getInstance().getIcon("Save.png"));
        saveEmployeesButton.setEnabled(false); //Standardmäßig disabled (nothing to save...)
        saveEmployeesButton.setBackground(new Color(77, 60, 60));
        saveEmployeesButton.addActionListener(a -> {
            save();
        });
        managePanel.add(saveEmployeesButton);

        loadEmployeesButton = new JButton();
        loadEmployeesButton.setToolTipText("Aus CSV-Datei importieren");
        loadEmployeesButton.setIcon(ImageHandler.getInstance().getIcon("Import.png"));
        loadEmployeesButton.setBackground(new Color(77, 60, 60));
        loadEmployeesButton.addActionListener(a -> {
            load();
        });
        managePanel.add(loadEmployeesButton);

        return managePanel;
    }

    private JTabbedPane getVisualizeEmployeesPanel() {
        tabbedPane = new JTabbedPane();

        allEmployeesTable = new EmployeeTable<>(Employee.class);
        allEmployeesTable.setData(management.getEmployees());

        //OfficeWorker
        allOfficeWorkersTable = new EmployeeTable<>(OfficeWorker.class);
        List<OfficeWorker> officeWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof OfficeWorker).map(e -> (OfficeWorker) e).forEach(officeWorkers::add);
        allOfficeWorkersTable.setData(officeWorkers);

        //Manager
        allManagersTable = new EmployeeTable<>(Manager.class);
        List<Manager> managers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof Manager).map(e -> (Manager) e).forEach(managers::add);
        allManagersTable.setData(managers);

        //Schichtarbeiter
        allShiftWorkersTable = new EmployeeTable<>(ShiftWorker.class);
        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);
        allShiftWorkersTable.setData(shiftWorkers);

        //Fahrer
        allDriversTable = new EmployeeTable<>(Driver.class);
        List<Driver> drivers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof Driver).map(e -> (Driver) e).forEach(drivers::add);
        allDriversTable.setData(drivers);

        tabbedPane.addTab("Mitarbeiter", new JScrollPane(allEmployeesTable));
        tabbedPane.addTab("Büroarbeiter", new JScrollPane(allOfficeWorkersTable));
        tabbedPane.addTab("Manager", new JScrollPane(allManagersTable));
        tabbedPane.addTab("Schichtarbeiter", new JScrollPane(allShiftWorkersTable));
        tabbedPane.addTab("Fahrer", new JScrollPane(allDriversTable));
        return tabbedPane;
    }

    private void addEmployee() {
        createEmployeeDialog.setVisible(true);
    }

    public void addEmployee(Employee e) {
        management.addEmployee(e);
        updateGUI();
    }

    public void removeEmployee(Employee e) {
        management.removeEmployee(e);
        updateGUI();
    }

    private void removeSelectedEmployee() {
        //aktuell gezeigte Tabelle finden
        tabbedPane.getTabComponentAt(tabbedPane.getSelectedIndex());

        EmployeeTable<?> currentTable;
        try {
            currentTable = (EmployeeTable<?>) ((JScrollPane) tabbedPane.getSelectedComponent()).getViewport().getView();
        } catch (Exception e) {
            return;
        }

        //Mitarbeiter aus der Tabelle lesen
        Employee[] employees = currentTable.getSelectedEmployees();

        if (employees != null && employees.length!=0)
            JOptionPane.showConfirmDialog(this,
                    "Sicher, dass sie diese Mitarbeiter löschen möchten?",
                    "Achtung",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    ImageHandler.getInstance().getIcon("RemoveEmployee.png"));
        else
            return;

        //Diese Mitarbeiter löschen
        for (Employee empl : employees) removeEmployee(empl);
    }

    private void save() {
        String[] data = management.getEmployees().stream().map(Employee::getCSVString).toArray(String[]::new);
        File f = new File(USER_HOME + File.separator + CSV_FILE_NAME);
        if (!f.getParentFile().exists()) {
            throw new RuntimeException("Datei kann nicht gespeichert werden.");
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Datei \"" + f + "\" kann nicht gespeichert werden.");
            }
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(f))) {
            Arrays.stream(data).forEach(text -> {
                try {
                    br.write(text + "\n");
                } catch (IOException e) {
                    System.err.println("Text \"" + text + "\" konnte nicht gespeichert werden.");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Datei " + f + " gefüllt.");
    }

    private void load() {
        File f = new File(USER_HOME + File.separator + CSV_FILE_NAME);
        if (!f.exists()) {
            throw new RuntimeException("Datei " + f + " existiert nicht.");
        }
        String[] data;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            data = br.lines().toArray(String[]::new);
        } catch (Exception e) {
            throw new RuntimeException("Datei " + f + " konnte nicht gelesen werden.");
        }

        for (String employeeData : data) {
            try {
                addEmployee(Employee.getEmployeeFromCSVString(employeeData));
            } catch (Exception e) {
                throw new RuntimeException("Mitarbeiter \"" + employeeData + "\" konnte nicht gespeichert werden");
            }
        }
    }

    private void updateGUI() {
        allEmployeesTable.setData(management.getEmployees());

        //OfficeWorker
        List<OfficeWorker> officeWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof OfficeWorker).map(e -> (OfficeWorker) e).forEach(officeWorkers::add);
        allOfficeWorkersTable.setData(officeWorkers);
        //Manager
        List<Manager> managers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof Manager).map(e -> (Manager) e).forEach(managers::add);
        allManagersTable.setData(managers);
        //Schichtarbeiter
        List<ShiftWorker> shiftWorkers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof ShiftWorker).map(e -> (ShiftWorker) e).forEach(shiftWorkers::add);
        allShiftWorkersTable.setData(shiftWorkers);
        //Fahrer
        List<Driver> drivers = new ArrayList<>();
        management.getEmployees().stream().filter(e -> e instanceof Driver).map(e -> (Driver) e).forEach(drivers::add);
        allDriversTable.setData(drivers);


        //Buttons (Load/Save aktualisieren)
        ArrayList<Employee> employees = management.getEmployees();
        saveEmployeesButton.setEnabled(!employees.isEmpty());
        loadEmployeesButton.setEnabled(employees.isEmpty());

        revalidate();
    }

}
