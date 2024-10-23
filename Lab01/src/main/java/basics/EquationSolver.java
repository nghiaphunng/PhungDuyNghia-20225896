package basics;

import javax.swing.*;

public class EquationSolver {
    private static void solveLinearEquation(double numA, double numB){
        if(numA == 0){
            if(numB == 0){
                JOptionPane.showMessageDialog(null, "Phuong trinh co vo so nghiem"
                        , "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem"
                        , "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            double res = - (numB / numA);
            JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem x = " + res,
                    "Ket qua", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //pt ax+b=0
    public static void solveLinearEquationMain(){
        String strNumA = JOptionPane.showInputDialog(null, "Nhập hệ số a: ", "Phương trình bậc nhất", JOptionPane.INFORMATION_MESSAGE);
        String strNumB = JOptionPane.showInputDialog(null, "Nhập hệ số b: ", "Phương trình bậc nhất", JOptionPane.INFORMATION_MESSAGE);

        double numA = Double.parseDouble(strNumA);
        double numB = Double.parseDouble(strNumB);

        solveLinearEquation(numA, numB);
    }

    //hpt 2 an
    public static void solveLinearSystem(){
        String strNumA11 = JOptionPane.showInputDialog(null, "Nhap he so a11: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);
        String strNumA12 = JOptionPane.showInputDialog(null, "Nhap he so a12: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);
        String strNumB1 = JOptionPane.showInputDialog(null, "Nhap he so b1: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);
        String strNumA21 = JOptionPane.showInputDialog(null, "Nhap he so a21: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);
        String strNumA22 = JOptionPane.showInputDialog(null, "Nhap he so a22: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);
        String strNumB2 = JOptionPane.showInputDialog(null, "Nhap he so b2: ",
                "Hpt bac nhat 2 an", JOptionPane.INFORMATION_MESSAGE);

        double a11 = Double.parseDouble(strNumA11);
        double a12 = Double.parseDouble(strNumA12);
        double a21 = Double.parseDouble(strNumA21);
        double a22 = Double.parseDouble(strNumA22);
        double b1 = Double.parseDouble(strNumB1);
        double b2 = Double.parseDouble(strNumB2);

        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;

        if(d == 0){
            if(d1 == 0 && d2 == 0){
                JOptionPane.showMessageDialog(null, "Hpt vo so nghiem",
                        "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Hpt vo nghiem",
                        "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            double x1 = d1 / d;
            double x2 = d2 / d;
            JOptionPane.showMessageDialog(null, "Hpt co nghiem: x1 = " + x1 + ", x2 = " + x2,
                    "Ket qua", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //pt bac 2
    public static void solveQuadraticEquation(){
        String strNumA = JOptionPane.showInputDialog(null, "Nhap he so a: ",
                "Pt bac 2", JOptionPane.INFORMATION_MESSAGE);
        String strNumB = JOptionPane.showInputDialog(null, "Nhap he so b: ",
                "Pt bac 2", JOptionPane.INFORMATION_MESSAGE);
        String strNumC = JOptionPane.showInputDialog(null, "Nhap he so c: ",
                "Pt bac 2", JOptionPane.INFORMATION_MESSAGE);

        double numA = Double.parseDouble(strNumA);
        double numB = Double.parseDouble(strNumB);
        double numC = Double.parseDouble(strNumC);

        if(numA == 0){
            solveLinearEquation(numB, numC);
        }
        else {
            double delta = numB * numB - 4 * numA * numC;
            if(delta > 0){
                double x1 = (-numB + Math.sqrt(delta)) / (2 * numA);
                double x2 = (-numB - Math.sqrt(delta)) / (2 * numA);
                JOptionPane.showMessageDialog(null, "Pt co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(delta == 0){
                double x = -numB / (2 * numA);
                JOptionPane.showMessageDialog(null, "Pt co nghiem kep: x = " + x,
                        "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Pt vo nghiem",
                        "Ket qua", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        String strChoice = "Pt bac nhat 1 an: 1\n"
                + "Hpt bac nhat 2 an: 2\n"
                + "Pt bac hai 1 an: 3";

        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, strChoice, "Giai phuong trinh", JOptionPane.INFORMATION_MESSAGE));

        switch (choice){
            case 1:
                solveLinearEquationMain();
                break;
            case 2:
                solveLinearSystem();
                break;
            case 3:
                solveQuadraticEquation();
                break;
            default:
                System.exit(0);
        }
    }
}
