package furamaResort.controllers;

import furamaResort.libs.CheckValid;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("------------------ WELCOME TO FURAMA RESORT ------------------------");
        System.out.println("Main Menu: ");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.println("Please enter your choice: ");
        int choice = CheckValid.checkIntException();
        do {       //NOTE: Chú ý vị trí đăt do/while : nếu đặt ở đầu--> menu sẽ mị hiển thị 2 lần
            switch (choice) {
                case 1:
                    EmployeeController.employeeMiniController();  //OK
                    break;
                case 2:
                    CustomerController.customerMenu();
                    break;
                case 3:
                    FacilityController.facilityMenu();
                    break;
                case 4:
                    BookingController.bookingMenu();
                    break;
                case 5:
                    BusinessController.bookingMenu();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.err.println("The number is out of range. Please enter from 1 to 6: ");
                    choice = CheckValid.checkIntException();
            }
        } while (true);
    }
}

