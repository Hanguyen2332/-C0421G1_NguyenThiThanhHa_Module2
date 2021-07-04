package furamaResort.libs;

import java.util.Scanner;

public class CheckValid {
    static Scanner sc = new Scanner(System.in);

    public static int checkIntException() {
        boolean check = false;
        int choice = 0;
        while (!check) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format. Please enter NUMBER!");
            }
        }
        return choice;
    }

    public static float checkFloatException() {
        boolean check = false;
        float value = 0;
        while (!check) {
            try {
                value = Float.parseFloat(sc.nextLine());
                check = true;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format! Please enter NUMBER!");
            }
        }
        return value;
    }
}
