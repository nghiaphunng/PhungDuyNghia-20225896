package exercises;

import java.util.Scanner;

public class CheckNumberOfDay {
    private static int getMonth(String month){
        return switch (month.toLowerCase()) {
            case "january", "jan.", "jan", "1" -> 1;
            case "february", "feb.", "feb", "2" -> 2;
            case "march", "mar.", "mar", "3" -> 3;
            case "april", "apr.", "apr", "4" -> 4;
            case "may", "5" -> 5;
            case "june", "jun.", "jun", "6" -> 6;
            case "july", "jul.", "jul", "7" -> 7;
            case "august", "aug.", "aug", "8" -> 8;
            case "september", "sep.", "sep", "9" -> 9;
            case "october", "oct.", "oct", "10" -> 10;
            case "november", "nov.", "nov", "11" -> 11;
            case "december", "dec.", "dec", "12" -> 12;
            default -> -1;
        };
    }

    private static boolean checkLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                return (year % 400) == 0;
            }
            else return true;
        }
        return false;
    }

    private static int result(int month, int year){
        boolean checkLeapYear = checkLeapYear(year);
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> checkLeapYear ? 29 : 28;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthStr;
        int year;

        while(true){
            System.out.println("Nhap thang: ");
            monthStr = sc.nextLine().trim();

            int month = getMonth(monthStr);
            if(month == -1){
                System.out.println("Nhap sai thang");
                continue;
            }

            System.out.println("Nhap nam: ");
            if(sc.hasNextInt()){
                year = sc.nextInt();
                sc.nextLine();
            }
            else{
                System.out.println("Nhap sai nam");
                sc.nextLine();
                continue;
            }

            if(year < 0){
                System.out.println("Nhap sai nam");
                continue;
            }

            System.out.println("So ngay: " + result(month, year));

            break;
        }
    }
}
