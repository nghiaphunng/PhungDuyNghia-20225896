package exercises;

import javax.swing.*;

public class ChoosingOptionCustom {
    public static void main(String[] args) {
        Object[] options = {"I do", "I don’t"};
        int option = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == 0 ? "Yes" : "No"));

        System.exit(0);
    }
}
