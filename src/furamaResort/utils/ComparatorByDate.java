package furamaResort.utils;

import furamaResort.models.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ComparatorByDate implements Comparator<Booking>, Serializable {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate date1 = LocalDate.parse(o1.getStartDay(), formatter);
        LocalDate date2 = LocalDate.parse(o2.getStartDay(), formatter);
//        date1.compareTo(date2);
        if (!o1.getStartDay().equals(o2.getStartDay())) {
            return date1.compareTo(date2);
        } else {
            return date2.compareTo(date1);
        }
    }
}
