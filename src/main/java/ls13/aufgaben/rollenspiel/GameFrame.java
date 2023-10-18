package ls13.aufgaben.rollenspiel;

import ls13.aufgaben.rollenspiel.field.Matchfield;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        Matchfield field = new Matchfield(50, 50);
        add(new JScrollPane(field, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        pack();
    }
}
