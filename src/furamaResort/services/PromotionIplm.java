package furamaResort.services;

import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;
import furamaResort.models.Booking;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionIplm implements Promotion {
    private static Collection<Booking> customerUseServiceSet = BookingServiceIplm.bookingSet; //lấy booking.csv
    private static int[] vouchersArr = new int[3];

    public static void main(String[] args) {
        PromotionIplm promotionIplm = new PromotionIplm();
        promotionIplm.displayCustomerGetVoucher();
 }
    @Override
    public void display() {
        boolean check = false;
        while (!check) {
            System.out.println("Please enter year you want to show Booking : ");
            int year = CheckValid.checkIntException();
            for (Booking booking : customerUseServiceSet) {
                String bookingDate = booking.getStartDay();
                String[] arrBookingDate = bookingDate.split("/");
                if (year == Integer.parseInt(arrBookingDate[2])) {
                    System.out.println(booking);
                    check = true;
                }
            }
            if (!check) {
                System.err.println(year + " is no has Booking to show. Please enter another year: ");
            }
        }
    }

    @Override
    public void displayCustomerGetVoucher() {
        if (vouchersArr[0] == 0 && vouchersArr[1] == 0 & vouchersArr[2] == 0) {
            System.out.println("You have not set voucher yet! Please set the voucher fist");
        } else {
            int vouchers10 = vouchersArr[0];
            int vouchers20 = vouchersArr[1];
            int vouchers50 = vouchersArr[2];
            //hiển thị list get vouchers:
            System.out.println("Customer get voucher 10%: ");
            for (int i = 0; i < vouchers10; i++) {
                System.out.println(getThisMonthBooking().pop());
            }
            System.out.println("Customer get voucher 20%: ");
            for (int i = 0; i < vouchers20; i++) {
                if (getThisMonthBooking().empty()) {
                    System.out.println("Not have Customer get voucher 20% ");
                } else {
                    System.out.println(getThisMonthBooking().pop());
                }
            }
            System.out.println("Customer get voucher 50%: ");
            for (int i = 0; i < vouchers50; i++) {
                if (getThisMonthBooking().empty()) {
                    System.out.println("Not have Customer get voucher 50% ");
                } else {
                    System.out.println(getThisMonthBooking().pop());
                }
            }
        }
    }

    public int[] setVoucherNumbers() {
        int vouchers = getThisMonthBooking().size();
        System.out.println("This Month has " + vouchers + " Booking ");
        int vouchers10 = 0;
        int vouchers20 = 0;
        boolean check = false;
        while (!check) { //ok
            vouchers10 = Integer.parseInt(QuickInOut.inputOutput("Enter number of voucher 10% : "));
            if (vouchers10 >= 0 && vouchers10 <= vouchers) {
                //loop nhỏ --> nhập số lượng voucher 20 đến khi đúng
                while (!check) {
                    vouchers20 = Integer.parseInt(QuickInOut.inputOutput("Enter number of voucher 20% : "));
                    if (vouchers20 >= 0 && vouchers20 <= vouchers - vouchers10) {
                        check = true;
                    } else {
                        System.err.println("The number of vouchers 20% must be >= 0 & <= " + (vouchers - vouchers10) + "! Please enter again ");
                    }
                }
            } else {
                System.err.println("The number of vouchers 10% must be >= 0 & <= " + vouchers + "! Please enter again ");
            }
        }
        int vouchers50 = vouchers - vouchers10 - vouchers20;
        System.out.println("The number of voucher 50% = " + vouchers50);
        vouchersArr[0] = vouchers10;
        vouchersArr[1] = vouchers20;
        vouchersArr[2] = vouchers50;
        return vouchersArr;
    }

    public Stack<Booking> getThisMonthBooking() {
        Stack<Booking> bookingStack = new Stack<>();
        LocalDate currentDay = LocalDate.now();  //lấy ngày hệ thống
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");  //tạo format
        for (Booking booking : BookingServiceIplm.bookingSet) {
            //lấy ngày booking.csv:
            String bookingDate = booking.getStartDay();
            //format - lấy tháng -so sánh
            LocalDate bookingDateFormatter = LocalDate.parse(bookingDate, formatter); //format theo định dạng - chuyển sang kiểu LocalDate
            if (bookingDateFormatter.getMonth() == currentDay.getMonth()) {
                bookingStack.push(booking);  //đẩy booking.csv tháng hiện tại vào stack;
            }
        }
        if (bookingStack.empty()) {
            System.out.println("this month no has Booking");
        }
        return bookingStack;
    }
}
