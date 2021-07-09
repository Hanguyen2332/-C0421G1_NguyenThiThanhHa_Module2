package furamaResort.services;

import furamaResort.libs.CheckProperty;
import furamaResort.models.*;
import furamaResort.services.facility.FacilityServiceImpl;
import furamaResort.services.facility.HouseIplm;
import furamaResort.services.facility.RoomIplm;
import furamaResort.services.facility.VillaIplm;
import furamaResort.utils.*;

import java.io.File;
import java.util.*;

public class BookingServiceIplm extends CheckProperty implements BookingService {
    //CHƯA ghi đè: hashCode + equals --> k cho nhập trùng
    static Collection<Booking> bookingSet = new TreeSet<>(new ComparatorByDate());
    static Collection<Booking> bookingNeedContractSet = new TreeSet<>(new ComparatorByDate()); //LIST tạm
    //FILE chính thức
    private static ReadAndWrite<Booking> bookingFile = new ReadAndWrite<>();
    private static final String PATH_BOOKING = "src\\furamaResort\\data\\booking.csv";
    //File Booking mới cần tạo HĐ
    private static ReadAndWrite<Booking> bookingNeedContractFile = new ReadAndWrite<>();
    private static final String PATH_WAITING_CONTRACT = "src\\furamaResort\\data\\bookingWaitingContract.csv";

    static {
        bookingSet = bookingFile.readData(new File(PATH_BOOKING));  //đọc file --> khởi tạo giá trị cho bookingSet
        bookingNeedContractSet = bookingNeedContractFile.readData(new File(PATH_WAITING_CONTRACT));
    }

    @Override
    public void display() { //ok
        if (bookingNeedContractSet.isEmpty()) {
            System.err.println("Not have new booking");
        }
        for (Booking element : bookingNeedContractSet) {
            System.out.println(element);
        }
    }

    @Override
    public void addBooking() { //ok
        String bookingId = checkDuplicatedId();
        String startDay = ValidBookingDate.startDate();
        String endDay = ValidBookingDate.endDate(startDay);
        String customerCode = inputCustomerCode();
        String serviceCode = inputServiceCode();
        //thêm vào list:
        bookingSet.add(new Booking(bookingId, startDay, endDay, customerCode, serviceCode));
        bookingFile.writeData(PATH_BOOKING, bookingSet);  //lưu file gốc
        bookingNeedContractSet.add(new Booking(bookingId, startDay, endDay, customerCode, serviceCode)); //Lưu file tạm (FILE booking mới cần làm HĐ)
        bookingNeedContractFile.writeData(PATH_WAITING_CONTRACT, bookingNeedContractSet);
        //update maintain facility:
        updateMaintain(serviceCode);
    }

    public static String checkDuplicatedId() { //check ID trùng
        String bookingId = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            bookingId = ValidateInputData.bookingCode();
            for (Booking booking : bookingSet) {
                if (!bookingId.equals(booking.getBookingId())) {
                    count++;
                }
            }
            if (count == bookingSet.size()) {
                System.out.println("ok");
                check = true;
            } else {
                System.out.println("Booking ID cannot be duplicated! Please enter again: ");
            }
        }
        return bookingId;
    }

    public static String inputCustomerCode() {  //hiển thị list customer.csv - chọn giá trị
        Collection<Customer> customers = CustomerServiceImpl.getCustomerList();
        int i = 0;
        System.out.println("Customer list: ");
        String[] arr = new String[customers.size()];
        //in ra list customer.csv theo định dạng 'customerCode : thông tin object' --> add id vào mảng --> gọi lại phương thức có sẵn trong libs
        for (Customer customer : customers) {
            arr[i] = customer.getCode();
            i++;
            System.out.println(i + ". " + customer.getCode() + ": " + customer);
        }
        System.out.println("Please select the number to enter Service Code : ");
        return checkInputProperty(arr);
    }

    public static String inputServiceCode() { //hiển thị list service --> chọn serviceCode
        Map<Facility, Integer> facilityMap = FacilityServiceImpl.facilityMap;
        int i = 0;
        System.out.println("Please select the corresponding number to enter Service Code : ");
        String[] arr = new String[facilityMap.size()];
        for (Facility service : facilityMap.keySet()) {
            arr[i] = service.getServiceCode();
            i++;
            System.out.println(i + ". " + service.getServiceCode() + ": " + service);
        }
        return checkInputProperty(arr);
    }

    public void updateMaintain(String serviceCode) {
        for (Map.Entry<Facility, Integer> service : FacilityServiceImpl.facilityMap.entrySet()) {  // duyệt list facility
            if (serviceCode.equals(service.getKey().getServiceCode()) && service.getValue() < 5) {  //Kiểm tra có tồn tại ServiceCode này k?
                int value = service.getValue() + 1;
                //ghi nhận giá trị mới vào file
                if (service.getKey() instanceof Villa) { //nếu service là Villa:
                    VillaIplm.villaMap.put((Villa) service.getKey(), value);  //ép kiểu Facility --> Villa -->update value cho list Villa
                    (new ReadAndWriteMap<Villa, Integer>()).writeData("D:\\module2\\src\\furamaResort\\data\\villa.csv", VillaIplm.villaMap); //update file
                } else if (service.getKey() instanceof House) {//nếu service là House:
                    HouseIplm.houseMap.put((House) service.getKey(), value);
                    (new ReadAndWriteMap<House, Integer>()).writeData("D:\\module2\\src\\furamaResort\\data\\house.csv", HouseIplm.houseMap);
                } else {
                    RoomIplm.roomMap.put((Room) service.getKey(), value); //nếu service là Room:
                    (new ReadAndWriteMap<Room, Integer>()).writeData("D:\\module2\\src\\furamaResort\\data\\room.csv", RoomIplm.roomMap);
                }
            }
        }
    }
}
/* Note:
1. NG: MÃ booking.csv/customer.csv/employee.csv...: không được nhập trùng --> xử lý sau
2. NG: CHƯA xử lý được TH nhập trùng  --> OK

1. hiển thị treeSet theo thứ tự của 1 thuộc tính nào đó, dùng cú pháp:
TreeSet<T> treeSet = new TreeSet<>(new Comparator
    //override
     public int compare(T o1, T o2) {
         //đoạn code ghi đè:
         ...........
    }
);
nếu chỉ khai báo: TreeSet<T> treeSet = new TreeSet<>()
--> khi hiển display sẽ báo lỗi: "...can cast to Comparable"

2. Class ComparatorByDate: cũng phải implements Srializale --> nếu không --> Ex: "NotSerializableException: furamaResort.utils.ComparatorByDate"
 */