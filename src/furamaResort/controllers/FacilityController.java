package furamaResort.controllers;

import furamaResort.libs.CheckValid;
import furamaResort.services.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static FacilityServiceImpl facilityServiceIplm = new FacilityServiceImpl();
    static Scanner sc = new Scanner(System.in);

    public static void facilityMenu() {
        System.out.println("1. Display list facility\n" +
                "2. Add new facility\n" +
                "3. Edit new facility\n" +
                "4. Return main menu\n" +
                "Please enter your choice: ");
        int case_choice3 = CheckValid.checkIntException();
        while (true) {
            switch (case_choice3) {
                case 1:
                    //goi ham DISPLAY facility
                    System.out.println("1. Display ALL list\n" +
                            "2. Display MAINTAIN list \n" +
                            "3. Return main menu\n" +
                            "Please enter your choice: ");
                    int display_choice = CheckValid.checkIntException();
                    switch (display_choice) {
                        case 1:
                            //goi ham display All Facility
                            facilityServiceIplm.display();
                            break;
                        case 2:
                            //goi ham display maintain Facility
                            facilityServiceIplm.displayMaintainList();
                            break;
                        case 3:
                            //return mini MENU
                            facilityMenu();
                            break;
                        default:
                            System.err.println("The number is out of range. Please enter from 1 to 3");
                    }
                    break;
                case 2:
                    System.out.println("1. Add New Villa\n" +
                            "2. Add New House\n" +
                            "3. Add New Room\n" +
                            "4. Back to menu\n" +
                            "Please enter your choice: ");
                    int add_choice = CheckValid.checkIntException();
                    switch (add_choice) {
                        case 1:
                            //goi ham add VILLA
                            facilityServiceIplm.addNewVilla();
                            break;
                        case 2:
                            //goi ham add HOUSE
                            facilityServiceIplm.addNewHouse();
                            break;
                        case 3:
                            //goi ham add ROOM
                            facilityServiceIplm.addNewRoom();
                            break;
                        case 4:
                            //goi ham RETURN mini MENU
                            facilityMenu();
                            break;
                        default:
                            System.err.println("The number is out of range. Please enter from 1 to 4");
                    }
                    break;
                case 3:
                    System.out.println("1. Edit Villa\n" +
                            "2. Edit House\n" +
                            "3. Edit Room\n" +
                            "4. Back to menu\n" +
                            "Please enter your choice: ");
                    int edit_choice = CheckValid.checkIntException();
                    switch (edit_choice) {
                        case 1:
                            //goi ham edit VILLA
                            facilityServiceIplm.editVila();
                            break;
                        case 2:
                            //goi ham Edit HOUSE
                            facilityServiceIplm.editHouse();
                            break;
                        case 3:
                            //goi ham Edit ROOM
                            facilityServiceIplm.editRoom();
                            break;
                        case 4:
                            //goi ham RETURN mini MENU
                            facilityMenu();
                            break;
                        default:
                            System.err.println("The number is out of range. Please enter from 1 to 4");
                    }
                    break;
                case 4:
                    //goi ham RETURN MAIN MENU
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.err.println("The number is out of range. Please enter from 1 to 4");
            }
        }
    }
}
