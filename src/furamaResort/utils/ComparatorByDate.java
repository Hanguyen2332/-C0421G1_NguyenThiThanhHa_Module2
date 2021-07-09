package furamaResort.utils;

import furamaResort.models.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class ComparatorByDate implements Comparator<Booking>, Serializable {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate startDate1 = LocalDate.parse(o1.getStartDay(), formatter);
        LocalDate startDate2 = LocalDate.parse(o2.getStartDay(), formatter);
        LocalDate endDay1 = LocalDate.parse(o1.getEndDay(), formatter);
        LocalDate endDay2 = LocalDate.parse(o2.getEndDay(), formatter);

        //c1:
        if (startDate1.compareTo(startDate2) > 0){
            return 1;
        } else if (startDate1.compareTo(startDate2) < 0) {
            return -1;
        } else {
            if (endDay1.compareTo(endDay2) > 0) {
                return 1;
            } else if (endDay1.compareTo(endDay2) < 0) {
                return -1;
            } else {
                return 1;
            }


            //Cách 2:

//        long gapStartDay = ChronoUnit.DAYS.between(startDate1, startDate2);
//        long gapEndDay = ChronoUnit.DAYS.between(endDay1, endDay2);
//        long gapStartMonth = ChronoUnit.MONTHS.between(startDate1, startDate2);
//        long gapEndMonth = ChronoUnit.MONTHS.between(endDay1, endDay2);
//        long gapStartYear = ChronoUnit.YEARS.between(startDate1, startDate2);
//        long gapEndYear = ChronoUnit.YEARS.between(endDay1, endDay2);
//
//        if (gapStartYear == 0) {
//            if (gapStartMonth == 0) {
//                if (gapStartDay == 0) {
//                    if (gapEndYear == 0) {
//                        if (gapEndMonth == 0) {
//                            if (gapEndDay == 0) {
//                                return 1;
//                            } else if (gapEndDay < 0) {
//                                return 1;
//                            } else {
//                                return -1;
//                            }
//                        } else if (gapEndMonth < 0) {
//                            return 1;
//                        } else {
//                            return -1;
//                        }
//                    } else if (gapEndYear < 0) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                } else if (gapStartDay < 0) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            } else if (gapStartMonth < 0) {
//                return 1;
//            } else {
//                return -1;
//            }
//        } else if (gapStartYear < 0) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//}
        }
    }
}
