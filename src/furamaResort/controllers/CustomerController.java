package furamaResort.controllers;

import furamaResort.libs.CheckValid;
import furamaResort.services.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    static Scanner sc = new Scanner(System.in);
    public static void customerMenu () {
        CustomerServiceImpl customer = new CustomerServiceImpl();
        while (true) {
            System.out.println("1. Display list customer.csv\n" +
                    "2. Add new customer.csv\n" +
                    "3. Edit new customer.csv\n" +
                    "4. Return main menu\n" +
                    "Please enter your choice:");
            int case_choice2 = CheckValid.checkIntException();
            switch (case_choice2) {
                case 1:
                    //goi ham DISPLAY customer.csv: OK
                    customer.display();
                    break;
                case 2:
                    //goi ham ADD thi customer.csv: ok
                    customer.addNew();
                    break;
                case 3:
                    //goi ham EDIT thi customer.csv: ok
                    customer.edit();
                    break;
                case 4:
                    //goi ham RETURN MENU: ok
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.err.println("The number is out of range. Please enter from 1 to 4");
            }
        }
    }
}
