package furamaResort.controllers;

import furamaResort.models.employee.Employee;
import furamaResort.services.CustomerServiceImpl;
import furamaResort.services.EmployeeServiceImpl;

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
            int choice = sc.nextInt();
        do {       //NOTE: Chú ý vị trí đăt do/while : nếu đặt ở đầu--> menu sẽ mị hiển thị 2 lần
            switch (choice) {
                case 1:
                    EmployeeServiceImpl employee = new EmployeeServiceImpl();
                    System.out.println("1. Display list employee\n" +
                            "2. Add new employee\n" +
                            "3. Edit new employee\n" +
                            "4. Return main menu\n" +
                            "Please enter your choice:");
                    int case_choice1 = sc.nextInt();
                    switch (case_choice1) {
                        case 1:
                            //goi ham hien  nhan vien: ok
                            employee.display();
                            break;
                        case 2:
                            //goi ham ADD nhan vien: ok
                            employee.addNew();
                            break;
                        case 3:
                            //goi ham EDIT nhan vien : ok
                            employee.edit();
                            break;
                        case 4:
                            //goi ham RETURN MENU: ok
                            displayMainMenu();
                            break;
                    }
                    break;
                case 2:
                    CustomerServiceImpl customer = new CustomerServiceImpl();
                    System.out.println("1. Display list customer\n" +
                            "2. Add new customer\n" +
                            "3. Edit new customer\n" +
                            "4. Return main menu\n" +
                            "Please enter your choice:");
                    int case_choice2 = sc.nextInt();
                    switch (case_choice2) {
                        case 1:
                            //goi ham DISPLAY customer: OK
                            customer.display();
                            break;
                        case 2:
                            //goi ham ADD thi customer: ok
                            customer.addNew();
                            break;
                        case 3:
                            //goi ham EDIT thi customer: ok
                            customer.edit();
                            break;
                        case 4:
                            //goi ham RETURN MENU: ok
                            displayMainMenu();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Display list facility\n" +
                            "2. Add new facility\n" +
                            "3. Edit new facility\n" +
                            "4. Return main menu\n" +
                            "Please enter your choice:");
                    int case_choice3 = sc.nextInt();
                    switch (case_choice3) {
                        case 1:
                            //goi ham DISPLAY facility
                            break;
                        case 2:
                            //goi ham ADD thi facility
                            break;
                        case 3:
                            //goi ham EDIT thi facility
                            break;
                        case 4:
                            //goi ham RETURN MENU
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1. Add new booking\n" +
                            "2. Display list booking\n" +
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
                            break;
                    }
                    break;
                case 5:
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
                            break;
                    }
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("your input does NOT match. Please enter again: ");
            }
        } while (true);
    }
}

