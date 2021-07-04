package furamaResort.controllers;

import java.util.Scanner;

public class BookingController {
    static Scanner sc = new Scanner(System.in);

    public static void bookingMenu() {
        System.out.println("1.  Display list booking\n" +
                "2. Add new booking\n" +
                "3. Create new contracts\n" +
                "4. Display list contracts\n" +
                "5. Edit contracts\n" +
                "6. Return main menu\n" +
                "Please enter your choice: ");
        int case_choice4 = sc.nextInt();
        switch (case_choice4) {
            case 1:
                //goi ham ADD booking
                break;
            case 2:
                //goi ham DISPLAY booking
                break;
            case 3:
                //goi ham CREATE contracts
                break;
            case 4:
                //goi ham DISPLAY contracts
                break;
            case 5:
                //goi ham EDIT contracts
                break;
            case 6:
                //goi ham RETURN MENU
                FuramaController.displayMainMenu();
                break;
        }
    }
}
