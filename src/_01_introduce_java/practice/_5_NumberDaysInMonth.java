package _01_introduce_java.practice;

import java.util.Scanner;

public class _5_NumberDaysInMonth {
    public static void main(String[] args) {
        int month;
        Scanner inputMonth = new Scanner(System.in);
        System.out.println("Enter Month: ");
        month = inputMonth.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("The month " + month + " has 31 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("The month " +month + " has 30 days");
                break;
            case 2:
                System.out.println("The month " +month + " has 28 or 29 days");
                break;
            default:
                System.out.println("undefined");
        }
    }
}
