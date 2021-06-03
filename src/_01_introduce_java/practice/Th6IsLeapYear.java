package _01_introduce_java.practice;

import java.util.Scanner;

public class Th6IsLeapYear {
    public static void main(String[] args) {
        int year;

        Scanner inputYear = new Scanner(System.in);
        System.out.println("Enter year: ");
        year = inputYear.nextInt();
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " is a leap year");
        } else if (year % 100 == 0 && year % 400 == 0) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is NOT a leap year");
        }
    }
}
