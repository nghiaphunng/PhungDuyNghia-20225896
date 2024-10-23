package basics;

import javax.swing.*;

public class CalculateTwoDoubleNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double num1, num2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: "
                , "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: "
                , "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        num1 = Double.parseDouble(strNum1);
        num2 = Double.parseDouble(strNum2);

        //tính toán
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        String quotient = "";
        if(num2 != 0){
            quotient = String.valueOf(num1/ num2);
        }
        else {
            quotient = "error: The second number must be non-zero";
        }

        String message = "Sum = " + sum + "\n"
                + "Difference = " + difference + "\n"
                + "Product = " + product + "\n"
                + "Quotient = " + quotient;

        //hiển thị kết quả
        JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
