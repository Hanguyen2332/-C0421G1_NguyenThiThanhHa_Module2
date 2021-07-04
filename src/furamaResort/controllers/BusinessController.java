package furamaResort.controllers;

import java.util.Scanner;

public class BusinessController {
    static Scanner sc = new Scanner(System.in);

    public static void bookingMenu() {
        System.out.println("1. Display list customer use service\n" +
                "2. Display list customer get voucher\n" +
                "3. Return main menu\n" +
                "Please enter your choice:");
        int case_choice5 = sc.nextInt();
        switch (case_choice5) {
            case 1:
                //goi ham DISPLAY customer USE service
                break;
            case 2:
                //goi ham DISPLAY customer  GET voucher
                break;
            case 3:
                //goi ham RETURN MENU
                FuramaController.displayMainMenu();
                break;
        }
    }
}
