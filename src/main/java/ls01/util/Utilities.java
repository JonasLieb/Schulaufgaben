package ls01.util;

import javax.swing.JOptionPane;

public class Utilities {
    /**
     * privat constructor: prevent object-creation
     */
    private Utilities() {
    }

    /**
     * will get a string from the input
     *
     * @param commandPrompt        first shown message
     * @param commandPromptOnError shown message if the input was invalid
     * @return
     */
    public static String getString(String commandPrompt, String commandPromptOnError) {
        String ret;
        String msg;
        for (int i = 0; ; i++) {
            if (i == 0)
                msg = commandPrompt;
            else
                msg = commandPromptOnError;
            ret = JOptionPane.showInputDialog(msg);
            if (ret != null && !ret.isEmpty())
                return ret;
            else
                continue;

        }
    }

    /**
     * will get a char from the input
     *
     * @param commandPrompt        first shown message
     * @param commandPromptOnError shown message if the input was invalid
     * @return
     */
    public static char getChar(String commandPrompt, String commandPromptOnError) {
        String ret;
        String msg;
        for (int i = 0; ; i++) {
            if (i == 0)
                msg = commandPrompt;
            else
                msg = commandPromptOnError;
            ret = JOptionPane.showInputDialog(msg);
            if (ret != null && !ret.isEmpty() && ret.trim().length() == 1)
                return ret.charAt(0);
            else
                continue;

        }
    }

    /**
     * will get an integer from the input
     *
     * @param commandPrompt        first shown message
     * @param commandPromptOnError shown message if the input was invalid
     * @return
     */
    public static int getInt(String commandPrompt, String commandPromptOnError) {
        String msg;
        for (int i = 0; ; i++) {
            if (i == 0)
                msg = commandPrompt;
            else
                msg = commandPromptOnError;
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

    /**
     * will get an integer from the input
     *
     * @param commandPrompt        first shown message
     * @param commandPromptOnError shown message if the input was invalid
     * @return
     */
    public static int getInt(String commandPrompt, String commandPromptOnError, int min, int max) {
        String msg;
        for (int i = 0; ; i++) {
            if (i == 0)
                msg = commandPrompt;
            else
                msg = commandPromptOnError;
            try {
                int ret = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if (ret <= max && ret >= min) {
                    return ret;
                }
                continue;
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

    /**
     * will get a double from the input
     *
     * @param commandPrompt        first shown message
     * @param commandPromptOnError shown message if the input was invalid
     * @return
     */
    public static double getDouble(String commandPrompt, String commandPromptOnError) {
        String msg;
        for (int i = 0; ; i++) {
            if (i == 0)
                msg = commandPrompt;
            else
                msg = commandPromptOnError;
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(msg));
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

}