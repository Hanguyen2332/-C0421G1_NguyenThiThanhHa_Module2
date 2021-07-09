package furamaResort.services.facility;

import furamaResort.models.Booking;
import furamaResort.utils.ComparatorByDate;
import javafx.scene.effect.SepiaTone;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class TestBooking {
    public static void main(String[] args) {
//        new TestBooking().book();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String date1 = "11/11/1995";
        String date2 = "15/11/1996";

        LocalDate datef1 = LocalDate.parse(date1, formatter);
        LocalDate dateF2 = LocalDate.parse(date2, formatter);
//        LocalDate endDay1 = LocalDate.parse(o1.getEndDay(), formatter);
//        LocalDate endDay2 = LocalDate.parse(o2.getEndDay(), formatter);
        long gapStartDay = ChronoUnit.DAYS.between(datef1, dateF2);
//        long gapEndDay = ChronoUnit.DAYS.between(endDay1, endDay2);
//        int gapStartDay = Period.between(datef1, dateF2).getDays();
        System.out.println(gapStartDay);
//        int gapEndDay = Period.between(endDay1, endDay2).getDays();
    }
    Set<Booking> bookingSet = new TreeSet<>(new ComparatorByDate());
    public void book(){
        bookingSet.add(new Booking("1","2","3","4","5"));
        bookingSet.add(new Booking("2","2","3","4","5"));
        bookingSet.add(new Booking("6","2","3","4","5"));
        bookingSet.add(new Booking("4","2","3","4","5"));
        for (Booking booking : bookingSet){
            System.out.println(booking.toString());
        }
    }
}
