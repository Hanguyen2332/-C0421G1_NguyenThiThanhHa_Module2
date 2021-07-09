package furamaResort.controllers.facilityController;

import furamaResort.controllers.FuramaController;
import furamaResort.libs.CheckValid;
import furamaResort.models.Facility;
import furamaResort.services.facility.FacilityServiceImpl;
import furamaResort.services.facility.HouseIplm;
import furamaResort.services.facility.RoomIplm;
import furamaResort.services.facility.VillaIplm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityController {
    static FacilityServiceImpl facilityServiceIplm = new FacilityServiceImpl();
    static VillaIplm villaIplm = new VillaIplm();
    private static HouseIplm houseIplm = new HouseIplm();
    private static RoomIplm roomIplm = new RoomIplm();

    static Scanner sc = new Scanner(System.in);

    public static void facilityMenu() {
        while (true) {
            System.out.println("----Facility Menu----\n" +
                "1. Display list facility\n" +
                "2. Display Maintain list\n" +
                "3. Add new facility\n" +
                "4. Edit new facility\n" +
                "5. Delete facility\n" +
                "6. Return main menu\n" +
                "Please enter your choice: ");
        int case_choice3 = CheckValid.checkIntException();
            switch (case_choice3) {
                case 1:
                    //goi 3 ham DISPLAY villa/house/room
                    villaIplm.display();
                    houseIplm.display();
                    roomIplm.display();
                    break;
                case 2:
                    //dislay maintain:
                    villaIplm.displayMaintainList();
                    houseIplm.displayMaintainList();
                    roomIplm.displayMaintainList();
                    break;
                case 3:
                    //goi ham add villa/house/room
                    AddMethodController.addNewFacility();
                    break;
                case 4:
                    //goi ham edit VILLA
                    EditMethodController.editFacility();
                break;
                case 5:
                    //goi delete:
                    DeleteController.deleteFacility();
                    break;
                case 6:
                    //goi ham RETURN MAIN MENU
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.err.println("The number is out of range. Please enter from 1 to 6");
            }
        }
    }
}
