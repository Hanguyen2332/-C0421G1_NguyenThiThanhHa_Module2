package furamaResort.services.facility;

import furamaResort.libs.CheckProperty;
import furamaResort.models.House;
import furamaResort.models.Villa;
import furamaResort.utils.ReadAndWriteMap;
import furamaResort.utils.ValidateInputData;

import java.util.LinkedHashMap;
import java.util.Map;

public class HouseIplm implements FacilityService {
    public static Map<House, Integer> houseMap = new LinkedHashMap<>();
    //house
    private static ReadAndWriteMap<House, Integer> houseFile = new ReadAndWriteMap<>();
    private static final String PATH_HOUSE = "D:\\module2\\src\\furamaResort\\data\\house.csv";

    static {
        houseMap = houseFile.readData(PATH_HOUSE);
    }

    @Override
    public void display() {
        if (houseMap.size() == 0) {
            System.err.println("House list is EMPTY");
        } else {
            for (Map.Entry<House, Integer> service: houseMap.entrySet()) {
                System.out.println(service);
            }
        }
    }

    @Override
    public void displayMaintainList() {
        //in list cần bảo trì:
        int count = 0;
        for (Map.Entry<House, Integer> service : houseMap.entrySet()) {
            if (service.getValue() == 5) {
                System.out.println(service);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("No House need to maintain ");
        }
    }

    @Override
    public void addNew() {
        String houseCode = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            houseCode = ValidateInputData.houseCode();
            for (House house : houseMap.keySet()) {
                if (!houseCode.equals(house.getServiceCode())) {
                    count++;
                }
            }
            if (count == houseMap.size()) {
                System.out.println("ok");
                check = true;
            } else {
                System.err.println("House Code cannot be duplicated! Please enter again: ");
            }
        }

        double useArea = ValidateInputData.area();
        double rentalFee = ValidateInputData.rentalFee();
        int maxNumsPeople = ValidateInputData.maxNumsPeople();
        //nhập kiểu thuê:
        System.out.println("Enter rental type: ");
        String[] villaRentalTypes = {"HO-year", "HO-month", "HO-day", "HO-hour"};
        String rentalType = CheckProperty.checkInputProperty(villaRentalTypes);
        //nhập standard:
        String houseStandard = ValidateInputData.houseStandard();
        //floors
        int floors = ValidateInputData.numsOfFloors();
        houseMap.put(new House(houseCode, useArea, rentalFee, maxNumsPeople, rentalType, houseStandard, floors), 0);
        houseFile.writeData(PATH_HOUSE, houseMap);
    }

    @Override
    public void edit() {
        boolean check = false;
        while (!check) {
            String houseCode = ValidateInputData.houseCode();
            for (House service : houseMap.keySet()) {
                if (houseCode.equals(service.getServiceCode())) {
                    check = true;
                    service.setUseArea(ValidateInputData.area());
                    service.setRentalFees(ValidateInputData.rentalFee());
                    service.setMaxNumsPeople(ValidateInputData.maxNumsPeople());
                    System.out.println("Enter rental type: "); //không cần regex, vì chỉ có 4 lựa chọn cố định
                    String[] villaRentalTypes = {"HO-year", "HO-month", "HO-day", "HO-hour"};
                    service.setRentalType(CheckProperty.checkInputProperty(villaRentalTypes));
                    service.setStandard(ValidateInputData.villaStandard());
                    service.setFloors(ValidateInputData.numsOfFloors());
                    houseFile.writeData(PATH_HOUSE, houseMap);
                    break;
                }
            }
            if (!check) {
                System.out.println("NOT found this house code. Please try again: ");
            }
        }
    }

    @Override
    public void delete() {
        boolean check = false;
        while (!check) {
            String houseCode = ValidateInputData.houseCode();
            for (House service : houseMap.keySet()) {
                if (houseCode.equals(service.getServiceCode())) {
                    check = true;
                    houseMap.remove(service);
                    houseFile.writeData(PATH_HOUSE, houseMap);
                    break;
                }
            }
            if (!check) {
                System.out.println("NOT found this house code. Please try again: ");
            }
        }
    }
}
