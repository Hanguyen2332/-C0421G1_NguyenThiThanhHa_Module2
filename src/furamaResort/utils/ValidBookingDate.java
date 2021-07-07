package furamaResort.utils;

import furamaResort.libs.QuickInOut;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ValidBookingDate {
    public static void main(String[] args) {
//        startDate();
        endDate("07/07/2021");
    }
    public static String startDate() { //ok
        String regex = "^(?=\\d{2}([\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|" +
                "[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
        boolean check = false;
        String startDate = null;
        while (!check) {
            startDate = QuickInOut.inputOutput("Enter START day: ");
            if (Pattern.matches(regex,startDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
                LocalDate formatStartDay = (LocalDate.parse(startDate,formatter));
                LocalDate currentDate = LocalDate.now();
                int gap = Period.between(currentDate,formatStartDay).getDays();
                if (gap >= 0) {
                    System.out.println("ok");
                    check = true;
                }else {
                    System.err.println("Start date must be equal or greater than current date! ");
                }
            }else {
                System.err.println("Wrong format. Please input day according to format: 'dd/MM/yyy'\n" +
                        "And make sure the number of days in the month is valid ");
            }
        }
        return startDate;
    }
    public static String endDate(String startDate) { //ok
        String regex = "^(?=\\d{2}([\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|" +
                "[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
        boolean check = false;
        String endDate = null;
        while (!check) {
            endDate = QuickInOut.inputOutput("Enter END day: ");
            if (Pattern.matches(regex,endDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
                LocalDate formatStartDate = (LocalDate.parse(startDate,formatter));
                LocalDate formatEndDate = (LocalDate.parse(endDate,formatter));
                int gap = Period.between(formatStartDate,formatEndDate).getDays();
                if (gap >= 0) {
                    System.out.println("ok");
                    check = true;
                }else {
                    System.err.println("END date must be equal or greater than START date! ");
                }
            }else {
                System.err.println("Wrong format. Please input day according to format: 'dd/MM/yyy'\n" +
                        "And make sure the number of days in the month is valid ");
            }
        }
        return endDate;
    }
}
