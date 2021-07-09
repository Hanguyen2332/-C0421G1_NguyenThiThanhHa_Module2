package furamaResort.controllers.facilityController;

import furamaResort.libs.CheckValid;
import furamaResort.services.facility.HouseIplm;
import furamaResort.services.facility.RoomIplm;
import furamaResort.services.facility.VillaIplm;

public class DeleteController {
    private static VillaIplm villaIplm = new VillaIplm();
    private static HouseIplm houseIplm = new HouseIplm();
    private static RoomIplm roomIplm = new RoomIplm();
    public static void deleteFacility() {
        while (true) {
            System.out.println("1. Delete Villa\n" +
                    "2. Delete house\n" +
                    "3. Delete room\n" +
                    "4. Return main menu\n" +
                    "Please enter your choice: ");
            int choice = CheckValid.checkIntException();
            switch (choice) {
                case 1:
                    //goi ham add villa
                    villaIplm.delete();
                    break;
                case 2:
                    //goi ham add villa
                    houseIplm.delete();
                    break;
                case 3:
                    //goi ham add house
                    roomIplm.delete();
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
