package exercises;

import java.util.Scanner;

public class SortAndCalArray {
    private static void bubbleSort(double[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static double sumArray(double[] array){
        double res = 0;
        for(double num : array) res += num;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so phan tu: n = ");
        int n  = sc.nextInt();
        double[] arr = new double[n];

        System.out.println("Nhap cac phan tu:");
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextDouble();
        }

        bubbleSort(arr);

        double sum = sumArray(arr);

        double ave = sum / n;

        System.out.println("Mang sau khi sap xep: ");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + ave);
    }
}
