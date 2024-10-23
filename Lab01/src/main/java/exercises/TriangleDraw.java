package exercises;

import java.util.Scanner;

public class TriangleDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap n = ");
        int n = sc.nextInt();

        for(int i = 0; i < n;i ++){
            for(int j = 0;j < n - i - 1;j ++){
                System.out.print(" ");
            }
            for(int k = 0;k < 2 * i + 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
