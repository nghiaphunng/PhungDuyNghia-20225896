package exercises;

import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?");

        JOptionPane.showMessageDialog(null, "You're chosen: "
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        //Do chỉ kiểm tra (option == JOptionPane.YES_OPTION) nên nếu không chọn Yes thì chỉ hiển thị ra "No"
        //nên khi chọn "Cancel" thì sẽ hiển trị "No"
        System.exit(0);
    }
}
