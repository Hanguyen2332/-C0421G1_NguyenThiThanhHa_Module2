package furamaResort.controllers;

import furamaResort.services.PromotionIplm;

import java.util.Scanner;

public class PromotionController {
    static Scanner sc = new Scanner(System.in);
    private static PromotionIplm promotionIplm = new PromotionIplm();
//private static CustomerServiceImpl customer = new CustomerServiceImpl();
    public static void bookingMenu() {
        while (true) {
            System.out.println("1. Display list customer use service\n" +
                "2. Display list customer get voucher\n" +
                "3. Set voucher \n" +
                "4. Return main menu\n" +
                "Please enter your choice:");
            int case_choice5 = sc.nextInt();
            switch (case_choice5) {
                case 1:
                    //goi ham DISPLAY customer USE service
//                businessIplm.display();
                    promotionIplm.display();
                    break;
                case 2:
                    //goi ham DISPLAY customer  GET voucher
                    promotionIplm.displayCustomerGetVoucher();
                    break;
                case 3:
                    //goi ham RETURN MENU
                    promotionIplm.setVoucherNumbers();
                    break;
                case 4:
                    //goi ham RETURN MENU
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.err.println("This choice is NOT available. Please enter from 1 to 4");
            }
        }
    }
}
