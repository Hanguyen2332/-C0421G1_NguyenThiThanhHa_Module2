package furamaResort.services;

import furamaResort.models.Booking;
import furamaResort.utils.ReadAndWrite;

import java.io.File;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceIplm implements BookingService {
    private static Collection<Booking> bookingSet = new TreeSet<>();  //CHƯA ghi đè: hashCode + equals --> k cho nhập trùng
    //file
    private static ReadAndWrite<Booking> bookingFile = new ReadAndWrite<>();
    private static final String PATH_FILE = "D:\\module2\\src\\furamaResort\\data\\booking" ;
    //khỏi tạo TreeMap:
    static {
        bookingSet = bookingFile.readData(new File(PATH_FILE));
    }

//static {
//    bookingSet.add(new Booking("BKVL-1234","05/07/2021","07/07/2021","CTM111","SVVL-1234","SVVL-day"));
//    bookingSet.add(new Booking("BKHO-4336","19/07/2021","20/08/2021","CTM444","SVHO-6780","SVHO-day"));
//    bookingSet.add(new Booking("BKRO-5311","08/07/2021","13/07/2021","CTM333","SVRO-5151","SVRO-day"));
//    bookingSet.add(new Booking("BKHO-4336","05/07/2021","09/07/2021","CTM222","SVHO-4141","SVHO-month"));
//}

    public static void main(String[] args) {
        bookingFile.writeData(PATH_FILE,bookingSet);
    }
    @Override
    public void display() {


    }

    @Override
    public void addBooking() {

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

}
