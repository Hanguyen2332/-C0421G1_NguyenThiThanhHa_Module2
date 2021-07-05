package furamaResort.services;

import furamaResort.libs.CheckProperty;
import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;
import furamaResort.models.*;
import furamaResort.utils.ComparatorByDate;
import furamaResort.utils.ReadAndWrite;

import java.io.File;
import java.util.*;

public class BookingServiceIplm extends CheckProperty implements BookingService {
    ////CHƯA ghi đè: hashCode + equals --> k cho nhập trùng
    private static Collection<Booking> bookingSet = new TreeSet<>(new ComparatorByDate());
    private static ReadAndWrite<Booking> bookingFile = new ReadAndWrite<>();
    private static final String PATH_FILE = "D:\\module2\\src\\furamaResort\\data\\booking";

    //khỏi tạo TreeMap:
    static {
        bookingSet = bookingFile.readData(new File(PATH_FILE));  //đọc file --> khởi tạo giá trị cho bookingSet
    }

//static {
//    bookingSet.add(new Booking("BKVL-1234", "05/07/2021", "07/07/2021", "CTM111",
//            "SVVL-1234", "SVVL-day"));
//    bookingSet.add(new Booking("BKHO-4336", "19/07/2021", "20/08/2021", "CTM444",
//            "SVHO-6780", "SVHO-day"));
//    bookingSet.add(new Booking("BKRO-5311", "08/07/2021", "13/07/2021", "CTM333",
//            "SVRO-5151", "SVRO-day"));
//    bookingSet.add(new Booking("BKHO-4336", "05/07/2021", "09/07/2021", "CTM222",
//            "SVHO-4141", "SVHO-month"));
//}

    public static void main(String[] args) {
        //bookingFile.writeData(PATH_FILE,bookingSet);  //ghi file

//        test display():
        BookingServiceIplm bookingServiceIplm = new BookingServiceIplm();
        bookingServiceIplm.display();


    }

    @Override
    public void display() {       //ok
        for (Booking element : bookingSet) {
            System.out.println(element);
        }
    }

    @Override
    public void addBooking() {
        String bookingId = QuickInOut.inputOutput("Enter booking ID: ");
        String startDay = QuickInOut.inputOutput("Enter start date: ");
        String endDay = QuickInOut.inputOutput("Enter end date: ");
        //chọn mã khách hàng:
        Collection<Customer> customers = CustomerServiceImpl.getCustomerList();
        int i = 0;
        System.out.println("Customer list: ");
        String[] arr = new String[customers.size()];
        for (Customer customer : customers) {
            arr[i] = customer.getCode();
            i++;
            System.out.println(i + ". " + customer.getCode() + ": " + customer);
        }
        System.out.println("Please select the number to enter Service Code : ");
        String customerCode = checkSelectCode(arr);
        //chọn mã dịch vụ:
        Map<Facility, Integer> facilityMap = FacilityServiceImpl.getFacilityMap();
        int j = 0;
        System.out.println("Please select the corresponding number to enter Service Code : ");
        String[] serviceCodes = new String[facilityMap.size()];
        String[] serviceTypes = new String[facilityMap.size()];
        for (Facility service : facilityMap.keySet()) {
            serviceCodes[j] = service.getServiceCode();
            serviceTypes[j] = service.getRentalType();
            j++;
            System.out.println(j + ". " + service.getServiceCode() + ": " + service);
        }
        String serviceCode = checkSelectCode(serviceCodes);
        //chọn kiểu dịch vụ:
        System.out.println("Please select the number to enter Service Type : ");
        int index = 0;
        for (Facility service : facilityMap.keySet()) {
            index++;
            System.out.println(index + ". " + service.getRentalType() + ": " + service);
        }
        String serviceType = checkSelectCode(serviceTypes);
        //thêm vào list:
        bookingSet.add(new Booking(bookingId,startDay,endDay,customerCode,serviceCode,serviceType));
        bookingFile.writeData(PATH_FILE,bookingSet);
    }

    @Override
    public void creatNewContract() {


    }

    @Override
    public void displayContract() {

    }

    @Override
    public void editContract() {

    }

    public static String checkSelectCode(String[] arr) {
        String value = null;
        boolean check = false;
        do {
            int choice = CheckValid.checkIntException();
            //check - gan value
            for (int i = 0; i < arr.length; i++) {
                if ((choice - 1) == i) {
                    value = arr[i];
                    check = true;
                    System.out.println("ok");
                    break;
                }
            }
            if (!check) {
                System.err.println("This choice is NOT available. Please enter value from 1 to " + arr.length);
            }
        } while (!check);
        return value;
    }
}
/* Note:
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