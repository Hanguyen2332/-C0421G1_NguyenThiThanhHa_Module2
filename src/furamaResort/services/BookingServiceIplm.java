package furamaResort.services;

import furamaResort.libs.CheckProperty;
import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;
import furamaResort.models.*;
import furamaResort.utils.ComparatorByDate;
import furamaResort.utils.ReadAndWrite;
import furamaResort.utils.ValidBookingDate;
import furamaResort.utils.ValidateInputData;

import java.io.File;
import java.util.*;

public class BookingServiceIplm extends CheckProperty implements BookingService {
    ////CHƯA ghi đè: hashCode + equals --> k cho nhập trùng
    private static Collection<Booking> bookingSet = new TreeSet<>(new ComparatorByDate());
    private static Collection<Booking> bookingNeedContractSet = new TreeSet<>(new ComparatorByDate()); //LIST tạm
    //FILE chính thức
    private static ReadAndWrite<Booking> bookingFile = new ReadAndWrite<>();
    private static final String PATH_BOOKING = "D:\\module2\\src\\furamaResort\\data\\booking";
    //File booking tạm cần tạo HĐ
    private static ReadAndWrite<Booking> bookingNeedContractFile = new ReadAndWrite<>();
    private static final String PATH_WAITING_CONTRACT = "D:\\module2\\src\\furamaResort\\data\\bookingWaitingContract";
    //Contract:
    private static Collection<Contract> contractList = new ArrayList<>();
    private static ReadAndWrite<Contract> contractFile = new ReadAndWrite<>();
    private static final String PATH_CONTRACT = "D:\\module2\\src\\furamaResort\\data\\contract";

    //khỏi tạo giá trị: ListBooking, listContract
    static {
        bookingSet = bookingFile.readData(new File(PATH_BOOKING));  //đọc file --> khởi tạo giá trị cho bookingSet
        bookingNeedContractSet = bookingNeedContractFile.readData(new File(PATH_WAITING_CONTRACT));
        contractList = contractFile.readData(new File(PATH_CONTRACT));
    }
//    static {
//            bookingSet.add(new Booking("BKVL-1234", "05/07/2021", "07/07/2021", "CTM111",
//                    "SVVL-1234"));
//            bookingSet.add(new Booking("BKHO-4336", "19/07/2021", "20/08/2021", "CTM444",
//                    "SVHO-6780"));
//            bookingSet.add(new Booking("BKRO-5311", "08/07/2021", "13/07/2021", "CTM333",
//                    "SVRO-5151"));
//            bookingSet.add(new Booking("BKHO-4336", "05/07/2021", "09/07/2021", "CTM222",
//                    "SVHO-4141"));
//        }
//
//    public static void main(String[] args) {
//        bookingFile.writeData(PATH_BOOKING,bookingSet);
//        bookingNeedContractFile.writeData(PATH_WAITING_CONTRACT,bookingSet);

//        BookingServiceIplm  bookingServiceIplm = new BookingServiceIplm();
//        bookingServiceIplm.display();
//    }

    @Override
    public void display() {       //ok
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
        bookingNeedContractSet.add(new Booking(bookingId, startDay, endDay, customerCode, serviceCode)); //cập nhật giá trị cho file tạm
        bookingNeedContractFile.writeData(PATH_WAITING_CONTRACT, bookingNeedContractSet);
    }

    public static String checkDuplicatedId() { //check ID trùng
        String bookingId = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            bookingId = QuickInOut.inputOutput("Enter booking ID: ");
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

    public static String inputCustomerCode() {  //hiển thị list customer - chọn giá trị
        Collection<Customer> customers = CustomerServiceImpl.getCustomerList();
        int i = 0;
        System.out.println("Customer list: ");
        String[] arr = new String[customers.size()];
        //in ra list customer theo định dạng 'ID : thông tin object' --> add id vào mảng --> gọi lại phương thức có sẵn trong libs
        for (Customer customer : customers) {
            arr[i] = customer.getCode();
            i++;
            System.out.println(i + ". " + customer.getCode() + ": " + customer);
        }
        System.out.println("Please select the number to enter Service Code : ");
        return checkInputProperty(arr);
    }

    public static String inputServiceCode() {
        Map<Facility, Integer> facilityMap = FacilityServiceImpl.getFacilityMap();
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

    @Override
    public void creatNewContract() {
        //chuyển Set --> Queue:
        java.util.Queue<Booking> queue = new LinkedList<>(bookingNeedContractSet);

        if (queue.isEmpty()) {
            System.err.println("No booking to make contract  ");
        }
        Booking booking = null;
        if (!queue.isEmpty()) {
            //pop từng phần tử ra khỏi queue --> check isVilla/isHouse ??
            booking = queue.poll();
            System.err.println("Booking : " + booking);
            String[] arrServiceName = booking.getServiceName().split("-");
            if (arrServiceName[0].equals("SVVL") || arrServiceName[0].equals("SVHO")) {
                //nhap contractCode - check duplicated:
                String contractCode = null;
                boolean check = false;
                while (!check) {
                    int count = 0;
                    contractCode = ValidateInputData.contractCode(); // update: input theo regex
                    for (Contract contract : contractList) {
                        if (!contractCode.equals(contract.getContractCode())) {
                            count++;
                        }
                    }
                    if (count == contractList.size()) {
                        System.out.println("value ok");
                        check = true;
                    } else {
                        System.err.println("Contract Code cannot be duplicated! Please enter again: ");
                    }
                }
                System.out.println("Enter deposit: ");
                double deposit = CheckValid.checkFloatException();
                System.out.println("Enter total payment: ");
                double totalPayment = CheckValid.checkFloatException();
                contractList.add(new Contract(contractCode, booking.getBookingId(), deposit, totalPayment, booking.getCustomerId()));
                contractFile.writeData(PATH_CONTRACT, contractList);
                System.out.println("Contract has been created ");
            }
        }
        bookingNeedContractSet.remove(booking); //update lại file
        bookingNeedContractFile.writeData(PATH_WAITING_CONTRACT, bookingNeedContractSet);
    }

    @Override
    public void displayContract() { //ok
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void editContract() {
        boolean check = false;
        while (!check) {
            String contractId = ValidateInputData.contractCode();
            for (Contract contract : contractList) {
                if (contractId.equals(contract.getContractCode())) {
                    System.out.println("Enter deposit: ");
                    contract.setDeposit(CheckValid.checkFloatException());
                    System.out.println("Enter total payment: ");
                    double totalPayment = CheckValid.checkFloatException();
                    contractFile.writeData(PATH_CONTRACT, contractList);
                    System.out.println("Contract has been edited ");
                    check = true;
                }
            }
            if (!check) {
                System.out.println("NOT found this contract ID. Please try again");
            }
        }
    }
    public static Collection<Booking> getBookingSet() {
        return bookingSet;
    }
}
/* Note:
1. Note: sửa lại display booking --> 2 choice: all list - new booking list

1. NG: MÃ booking/customer/employee...: không được nhập trùng --> xử lý sau
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