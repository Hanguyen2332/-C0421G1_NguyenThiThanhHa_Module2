package furamaResort.services.facility;

import furamaResort.libs.CheckProperty;
import furamaResort.models.Facility;
import furamaResort.models.Villa;
import furamaResort.utils.ReadAndWriteMap;
import furamaResort.utils.ValidateInputData;

import java.util.LinkedHashMap;
import java.util.Map;

public class VillaIplm implements FacilityService{
    public static Map<Villa, Integer> villaMap = new LinkedHashMap<>(); //nếu data-type là Facility --> khi edit, không thể gọi thuộc tính riêng của từng service
    //villa file
    private static ReadAndWriteMap<Villa, Integer> villaFile = new ReadAndWriteMap<>();
    private static final String PATH_VILLA = "D:\\module2\\src\\furamaResort\\data\\villa.csv";
    static {
        villaMap = villaFile.readData(PATH_VILLA);
    }

    @Override
    public void display() {
            if (villaMap.size() == 0) {
                System.err.println("Villa list is EMPTY");
            } else {
                for (Map.Entry<Villa,Integer> service : villaMap.entrySet()) {
                    System.out.println(service);
                }
            }
        }


    @Override
    public void displayMaintainList() {
        //in list cần bảo trì:
        int count = 0;
        for (Map.Entry<Villa, Integer> service : villaMap.entrySet()) {
            if (service.getValue() == 5) {
                System.out.println(service);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("No Villa need to maintain ");
        }
    }

    @Override
    public void addNew() {
        //nhap villaCode -  check code trùng?
        String villaCode = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            villaCode = ValidateInputData.villaCode();  //regex khác nhau --> không tạo method check chung cho 3 loại đc!
            for (Villa villa : villaMap.keySet()) {
                if (!villaCode.equals(villa.getServiceCode())) {
                    count++;
                }
            }
            if (count == villaMap.size()) {
                System.out.println("ok");
                check = true;
            } else {
                System.err.println("Villa Code cannot be duplicated! Please enter again: ");
            }
        }
        double useArea = ValidateInputData.area();
        double rentalFee = ValidateInputData.rentalFee();
        int maxNumsPeople = ValidateInputData.maxNumsPeople();
        //nhập kiểu thuê:
        System.out.println("Enter rental type: "); //không cần regex, vì chỉ có 4 lựa chọn cố định
        String[] villaRentalTypes = {"VL-year", "VL-month", "VL-day", "VL-hour"};
        String rentalType = CheckProperty.checkInputProperty(villaRentalTypes);
        //nhập standard:
        String villaStandard = ValidateInputData.villaStandard();
        //pool
        System.out.println("Enter pool : ");
        double poolArea = ValidateInputData.area();
        //floors
        int floors = ValidateInputData.numsOfFloors();
        villaMap.put(new Villa(villaCode, useArea, rentalFee, maxNumsPeople, rentalType, villaStandard, poolArea, floors), 0);
        villaFile.writeData(PATH_VILLA, villaMap);
    }

    @Override
    public void edit() {
        boolean check = false;
        while (!check) {
            String villaCode = ValidateInputData.villaCode();
            for (Villa service : villaMap.keySet()) {
                if (villaCode.equals(service.getServiceCode())) {
                    check = true;
                    service.setUseArea(ValidateInputData.area());
                    service.setRentalFees(ValidateInputData.rentalFee());
                    service.setMaxNumsPeople(ValidateInputData.maxNumsPeople());
                    System.out.println("Enter rental type: "); //không cần regex, vì chỉ có 4 lựa chọn cố định
                    String[] villaRentalTypes = {"VL-year", "VL-month", "VL-day", "VL-hour"};
                    service.setRentalType(CheckProperty.checkInputProperty(villaRentalTypes));
                    service.setStandard(ValidateInputData.villaStandard());
                    service.setPoolArea(ValidateInputData.area());
                    service.setFloors(ValidateInputData.numsOfFloors());
                    villaFile.writeData(PATH_VILLA, villaMap);
                    break;
                }
            }
            if (!check) {
                System.out.println("NOT found this villa code. Please try again: ");
            }
        }
    }

    @Override
    public void delete() {
        boolean check = false;
        while (!check) {
            String villaCode = ValidateInputData.villaCode();
            for (Villa service : villaMap.keySet()) {
                if (villaCode.equals(service.getServiceCode())) {
                    check = true;
                    villaMap.remove(service);
                    villaFile.writeData(PATH_VILLA, villaMap);
                    break;
                }
            }
            if (!check) {
                System.out.println("NOT found this villa code. Please try again: ");
            }
        }
    }
}
