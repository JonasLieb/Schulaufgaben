package ls09.aufgaben.oberserver.wetterstation;

import ls09.aufgaben.oberserver.wetterstation.observer.AktuelleBedingungen;
import ls09.aufgaben.oberserver.wetterstation.observer.WetterVorhersage;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class WetterGUI extends JFrame {

    public static final Color BACKGROUND_COLOR = new Color(60, 60, 60);

    public static final Color SECOND_BACKGROUND_COLOR = new Color(90, 90, 90);
    public static final Color FOREGROUND_COLOR = new Color(120, 120, 120);

    public WetterGUI(AktuelleBedingungen ab, WetterVorhersage wv) {
        initGUI(ab, wv);
        setMinimumSize(new Dimension(400, 400));
        pack();
    }


    private void initGUI(JPanel... panels) {
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        Arrays.stream(panels).forEach(mainPanel::add);
        this.add(mainPanel);
        this.setTitle("WetterÜbersicht");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
