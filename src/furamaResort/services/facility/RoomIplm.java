package furamaResort.services.facility;

import furamaResort.libs.CheckProperty;
import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;
import furamaResort.models.House;
import furamaResort.models.Room;
import furamaResort.utils.ReadAndWriteMap;
import furamaResort.utils.ValidateInputData;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoomIplm implements FacilityService {
    public static Map<Room, Integer> roomMap = new LinkedHashMap<>();
    //room
    private static ReadAndWriteMap<Room, Integer> roomFile = new ReadAndWriteMap<>();
    private static final String PATH_ROOM = "D:\\module2\\src\\furamaResort\\data\\room.csv";

    static {
        roomMap = roomFile.readData(PATH_ROOM);
    }

    @Override
    public void display() {
        if (roomMap.size() == 0) {
            System.err.println("Room list is EMPTY");
        } else {
            for (Map.Entry<Room, Integer> service : roomMap.entrySet()) {
                System.out.println(service);
            }
        }
    }

    @Override
    public void displayMaintainList() {
        //in list cần bảo trì:
        int count = 0;
        for (Map.Entry<Room, Integer> service : roomMap.entrySet()) {
            if (service.getValue() == 5) {
                System.out.println(service);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("No Room need to maintain ");
        }

    }

    @Override
    public void addNew() {
        //nhap roomCode -  check code trùng?
        String roomCode = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            roomCode = ValidateInputData.roomCode();
            for (Room room : roomMap.keySet()) {
                if (!roomCode.equals(room.getServiceCode())) {
                    count++;
                }
            }
            if (count == roomMap.size()) {
                System.out.println("ok");
                check = true;
            } else {
                System.err.println("Room Code cannot be duplicated! Please enter again: ");
            }
        }
        //
        double useArea = ValidateInputData.area();
        double rentalFee = ValidateInputData.rentalFee();
        int maxNumsPeople = ValidateInputData.maxNumsPeople();
        //nhập kiểu thuê:
        System.out.println("Enter rental type: ");
        String[] villaRentalTypes = {"RO-year", "RO-month", "RO-day", "RO-hour"};
        String rentalType = CheckProperty.checkInputProperty(villaRentalTypes);
        //tên dịch vụ đi kèm (Accompanied Service):
        String accompService = QuickInOut.inputOutput("Enter Accompanied Service: ");
        roomMap.put(new Room(roomCode, useArea, rentalFee, maxNumsPeople, rentalType, accompService), 0);
        roomFile.writeData(PATH_ROOM, roomMap);
    }

    @Override
    public void edit() {
//        Map<Room,Integer> servicesMap = roomFile.readData(PATH_ROOM);  //tạo list hứng kết quả --> ghi đè trở lại file
        boolean check = false;
        while (!check) {
            String roomCode = ValidateInputData.roomCode();
            for (Room service : roomMap.keySet()) {
                if (roomCode.equals(service.getServiceCode())) {
                    check = true;
                    service.setUseArea(ValidateInputData.area());
                    service.setRentalFees(ValidateInputData.rentalFee());
                    service.setMaxNumsPeople(ValidateInputData.maxNumsPeople());
                    System.out.println("Enter rental type: "); //không cần regex, vì chỉ có 4 lựa chọn cố định
                    String[] villaRentalTypes = {"RO-year", "RO-month", "RO-day", "RO-hour"};
                    service.setRentalType(CheckProperty.checkInputProperty(villaRentalTypes));
                    service.setFreeServices(QuickInOut.inputOutput("Enter free services name: "));
                    roomFile.writeData(PATH_ROOM, roomMap);
                    break;
                }
            }
            if (!check) {
                System.out.println("NOT found this room code. Please try again: ");
            }
        }
    }

    @Override
    public void delete() {
        boolean check = false;
        String roomCode = ValidateInputData.roomCode();
        System.out.println("Are you sure you want to delete this item?\n" +
                "1. Yes\n" +
                "2. No\n" +
                "Please enter your choice?");
        int choice = CheckValid.checkIntException();
        if (choice == 1) {
            while (!check) {
                for (Room service : roomMap.keySet()) {
                    if (roomCode.equals(service.getServiceCode())) {
                        check = true;
                        roomMap.remove(service);
                        roomFile.writeData(PATH_ROOM, roomMap);
                        break;
                    }
                }
                if (!check) {
                    System.out.println("NOT found this room code. Please try again: ");
                    roomCode = ValidateInputData.roomCode();
                }
            }
        }
    }
}


