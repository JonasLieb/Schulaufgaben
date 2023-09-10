package ls11.aufgaben.mitarbeitergui.util.swing;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Parameter;

public class ParameterPanel extends JPanel {

    private final Parameter parameter;
    private JTextField textField;

    public ParameterPanel(Parameter parameter) {
        this.parameter = parameter;
        initGUI();
    }

    private void initGUI() {
        this.setLayout(new GridLayout(1, 0));
        this.add(new JLabel(parameter.getName()));
        textField = new JTextField();
        this.add(textField);
    }

    public Parameter getParameter() {
        return parameter;
    }

    public String getValue() {
        return textField.getText().trim();
    }
}
