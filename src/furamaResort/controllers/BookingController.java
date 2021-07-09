package furamaResort.controllers;

import furamaResort.services.BookingServiceIplm;
import furamaResort.services.ContractIplm;

import java.util.Scanner;

public class BookingController {
    static Scanner sc = new Scanner(System.in);
    private static BookingServiceIplm bookingServiceIplm = new BookingServiceIplm();
    private static ContractIplm contractIplm = new ContractIplm();
    public static void bookingMenu() {
        System.out.println("1.  Display list booking.csv\n" +
                "2. Add new booking.csv\n" +
                "3. Create new contracts\n" +
                "4. Display list contracts\n" +
                "5. Edit contracts\n" +
                "6. Return main menu\n" +
                "Please enter your choice: ");
        int case_choice4 = sc.nextInt();
        switch (case_choice4) {
            case 1:
                //goi ham ADD booking.csv
                bookingServiceIplm.display();
                break;
            case 2:
                //goi ham DISPLAY booking.csv
                bookingServiceIplm.addBooking();
                break;
            case 3:
                //goi ham CREATE contracts
                contractIplm.creatNewContract();
                break;
            case 4:
                //goi ham DISPLAY contracts
                contractIplm.display();
                break;
            case 5:
                //goi ham EDIT contracts
                contractIplm.editContract();
                break;
            case 6:
                //goi ham RETURN MENU
                FuramaController.displayMainMenu();
                break;
        }
    }
}
