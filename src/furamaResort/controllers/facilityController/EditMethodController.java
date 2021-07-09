package furamaResort.controllers.facilityController;

import furamaResort.libs.CheckValid;
import furamaResort.services.facility.HouseIplm;
import furamaResort.services.facility.RoomIplm;
import furamaResort.services.facility.VillaIplm;

public class EditMethodController {
    private static VillaIplm villaIplm = new VillaIplm();
    private static HouseIplm houseIplm = new HouseIplm();
    private static RoomIplm roomIplm = new RoomIplm();

    public static void editFacility() {
        while (true) {
            System.out.println("1. Edit Villa\n" +
                    "2. Edit house\n" +
                    "3. Edit room\n" +
                    "4. Return main menu\n" +
                    "Please enter your choice: ");
        int choice = CheckValid.checkIntException();
            switch (choice) {
                case 1:
                    //goi ham add villa
                    villaIplm.edit();
                    break;
                case 2:
                    //goi ham add villa
                    houseIplm.edit();
                    break;
                case 3:
                    //goi ham add house
                    roomIplm.edit();
                    break;
                case 4:
                    FacilityController.facilityMenu();
                    break;
                default:
                    System.err.println("This choice NOT available. Please enter from 1 to 4");
            }
        }
    }
}
