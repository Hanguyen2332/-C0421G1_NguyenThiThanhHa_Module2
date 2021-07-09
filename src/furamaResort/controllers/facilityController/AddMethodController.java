package furamaResort.controllers.facilityController;

import furamaResort.libs.CheckValid;
import furamaResort.services.facility.HouseIplm;
import furamaResort.services.facility.RoomIplm;
import furamaResort.services.facility.VillaIplm;

public class AddMethodController {
    private static VillaIplm villaIplm = new VillaIplm();
    private static HouseIplm houseIplm = new HouseIplm();
    private static RoomIplm roomIplm = new RoomIplm();

    public static void addNewFacility() {
        while (true) {
            System.out.println("1. Add new Villa\n" +
                    "2. Add new house\n" +
                    "3. Add new room\n" +
                    "4. Return main menu\n" +
                    "Please enter your choice: ");
            int choice = CheckValid.checkIntException();
            switch (choice) {
                case 1:
                    //goi ham add villa
                    villaIplm.addNew();
                    break;
                case 2:
                    //goi ham add villa
                    houseIplm.addNew();
                    break;
                case 3:
                    //goi ham add house
                    roomIplm.addNew();
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
