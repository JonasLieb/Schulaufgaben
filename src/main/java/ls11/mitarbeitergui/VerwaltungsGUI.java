package ls11.mitarbeitergui;

import ls07.aufgaben.mitarbeiter_csv.BusinessManagement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VerwaltungsGUI extends JFrame {
    private final BusinessManagement management;

    public static void main(String[] args) {
        VerwaltungsGUI gui = new VerwaltungsGUI(new BusinessManagement());
        gui.setVisible(true);
    }

    public VerwaltungsGUI(BusinessManagement management) {
        this.management = management;
        initGUI();
        pack();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getManagePanel(), BorderLayout.WEST);
        mainPanel.add(getVisualizeEmployeesPanel(), BorderLayout.EAST);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private String getManagePanel() {
    }
}
