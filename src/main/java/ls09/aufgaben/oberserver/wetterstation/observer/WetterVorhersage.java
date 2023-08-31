package ls09.aufgaben.oberserver.wetterstation.observer;

import javafx.scene.control.Labeled;
import ls09.aufgaben.oberserver.wetterstation.observable.WetterDaten;
import ls09.aufgaben.oberserver.wetterstation.util.Observer;

import javax.swing.*;
import java.awt.*;


public class WetterVorhersage extends JPanel implements Observer {
    private static final int MAX_VALUE = 1000;
    private final WetterDaten daten;
    private float lastFeuchtigkeit;
    private float difference = 0f; //Letzter Unterschied der Werte (zwischen -MAX_VALUE und MAX_VALUE

    public WetterVorhersage(WetterDaten daten) {
        this.daten = daten;
        daten.addObserver(this);
        initGUI();
    }

    private void initGUI() {
//        JPanel feuchtigkeitsPanel = new JPanel(new GridLayout(0, 2));
//        feuchtigkeitsContentLabel = new JTextField(String.valueOf(daten.getFeuchtigkeit()));
//        feuchtigkeitsContentLabel.setEditable(false);
//        feuchtigkeitsContentLabel.setEditable(false);
//        feuchtigkeitsPanel.add(new JLabel("Feuchtigkeit:"));
//        feuchtigkeitsPanel.add(feuchtigkeitsContentLabel);
//
//
//        JPanel contentPanel = new JPanel(new GridLayout(3, 0));
//        contentPanel.add(feuchtigkeitsPanel);
//
//        this.setLayout(new BorderLayout());
//        this.add(new JLabel("Wettervorhersage"), BorderLayout.NORTH);
//        this.add(contentPanel, BorderLayout.CENTER);
//
//        setColors();
    }

//    private void setColors() {
//        Color c;
//        float feuchtigkeit = getFloat(feuchtigkeitsContentLabel);
//        if (feuchtigkeit < 0) c = null;
//        else if (feuchtigkeit < 33.3) c = Color.GREEN;
//        else if (feuchtigkeit < 66.7) c = Color.YELLOW;
//        else c = Color.RED;
//        feuchtigkeitsContentLabel.setBackground(c);
//    }

    private float getFloat(JTextField l) {
        try {
            return Float.parseFloat(l.getText().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

//    private void updateGUI() {
//        feuchtigkeitsContentLabel.setText(String.valueOf(daten.getFeuchtigkeit()));
//        setColors();
//        repaint();
//    }

    @Override
    public void update() {
        difference = daten.getFeuchtigkeit() - lastFeuchtigkeit;
        lastFeuchtigkeit = daten.getFeuchtigkeit();
        if (difference < 0) {
            difference = Math.max(difference, -1 * MAX_VALUE);
        } else if (difference > 0) {
            difference = Math.min(difference, MAX_VALUE);
        }

//        updateGUI();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        float angle = difference * 180 / MAX_VALUE;



//        g2D.rotate(Math.toRadians(90 + angle));
        g2D.drawLine(50, getHeight() / 5, 50, getHeight());
    }
}
