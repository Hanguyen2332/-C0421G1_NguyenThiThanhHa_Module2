package furamaResort.controllers;


import furamaResort.libs.CheckValid;
import furamaResort.services.EmployeeServiceImpl;


import java.util.Scanner;

public class EmployeeController {
    static Scanner sc = new Scanner(System.in);
    public static void employeeMiniController() {
        EmployeeServiceImpl employee = new EmployeeServiceImpl();
        while (true) {
            System.out.println("1. Display list employee\n" +
                "2. Add new employee\n" +
                "3. Edit new employee\n" +
                "4. Return main menu\n" +
                "Please enter your choice:");
            int case_choice1 = CheckValid.checkIntException();
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
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.err.println("The number is out of range. Please enter from 1 to 4");
            }
        }
    }
}
