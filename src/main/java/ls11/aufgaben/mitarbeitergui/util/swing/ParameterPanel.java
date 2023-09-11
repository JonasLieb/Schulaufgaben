package ls11.aufgaben.mitarbeitergui.util.swing;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class ParameterPanel extends JPanel {

    private final Parameter parameter;
    private final String name;
    private JTextField textField;

    public ParameterPanel(String parameterName, Parameter parameter) {
        this.name = parameterName;
        this.parameter = parameter;
        initGUI();
    }

    private void initGUI() {
        this.setLayout(new GridLayout(1, 0));
        this.add(new JLabel(name));
        textField = new JTextField();
        this.add(textField);
    }

    public Parameter getParameter() {
        return parameter;
    }

    public Object getValue() {
        String textValue = textField.getText().trim();
        String parameterType = parameter.getType().getName();
        if (parameterType == null || parameterType.isEmpty()) return null;
        if (parameterType.equalsIgnoreCase(String.class.getName()))
            return textValue;
        if (parameterType.equalsIgnoreCase(Integer.class.getName()) || parameterType.equalsIgnoreCase("INT"))
            try {
                return Integer.parseInt(textValue);
            } catch (NumberFormatException e) {
                return 0;
            }
        if (parameterType.equalsIgnoreCase(Double.class.getName()) || parameterType.equalsIgnoreCase("DOUBLE"))
            try {
                return Double.parseDouble(textValue);
            } catch (NumberFormatException e) {
                return 0d;
            }
        throw new RuntimeException("Achtung, der Parametertyp " + parameterType + " wird noch nicht unterstützt.");
    }
}
