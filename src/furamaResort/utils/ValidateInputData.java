package furamaResort.utils;

import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ValidateInputData <T> {
    public static void main(String[] args) {
//        double rentalFee = 1900055.237;
//        System.out.println(String.valueOf(rentalFee));
//        rentalFee();

        dateOfBirth();
    }

    //mã dịch vụ: đang phải làm 3 method cho 3 mã --> có cách nào gộp chung không?
    public static String villaCode() {
        String regex = "^(SVVL)-[0-9]{4}$";
        boolean check = false;
        String villaCode = null;
        while (!check) {
            villaCode = QuickInOut.inputOutput("Enter VILLA CODE accoding to format: 'SVVL-XXXX', where X is a number from 0-9 ");

            if (Pattern.matches(regex, villaCode)) {
                check = true;
            } else {
                System.err.println("Wrong format! please enter again: ");
            }
        }
        return villaCode;
    }

    public static String houseCode() {
        String regex = "^(SVHO)-[0-9]{4}$";
        boolean check = false;
        String houseCode = null;
        while (!check) {
            houseCode = QuickInOut.inputOutput("Enter HOUSE CODE accoding to format: 'SVHO-XXXX', where X is a number from 0-9 ");
            if (Pattern.matches(regex, houseCode)) {
                check = true;
            } else {
                System.err.println("Wrong format! please enter again: ");
            }
        }
        return houseCode;
    }

    public static String roomCode() {
        String regex = "^(SVRO)-[0-9]{4}$";
        boolean check = false;
        String roomCode = null;
        while (!check) {
            roomCode = QuickInOut.inputOutput("Enter ROOM CODE accoding to format: 'SVRO-XXXX', where X is a number from 0-9 ");
            if (Pattern.matches(regex, roomCode)) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong format! please enter again: ");
            }
        }
        return roomCode;  //ok
    }
    //mã Contract
    public static String bookingCode() {
        String regex = "^BK-\\d{4,6}$";
        String bookingCode = null;
        boolean check =  false;
        while (!check) {
            bookingCode = QuickInOut.inputOutput("Enter BOOKING CODE accoding to format: 'BK-XXXX', where X is a number from 0-9 ");
            if (Pattern.matches(regex,bookingCode)) {
                check = true;
            }else {
                System.err.println("Wrong format! please enter again: ");
            }
        }
        return bookingCode;
    }

    //mã Contract
    public static String contractCode() {
        String regex = "^CT-\\d{4,6}$";
        String contractCode = null;
        boolean check =  false;
        while (!check) {
            contractCode = QuickInOut.inputOutput("Enter CONTRACT CODE accoding to format: 'CT-XXXX', where X is a number from 0-9 ");
            if (Pattern.matches(regex,contractCode)) {
                check = true;
            }else {
                System.err.println("Wrong format! please enter again: ");
            }
        }
        return contractCode;
    }

    //Diện tích sử dụng: ok
    public static double area() {
        String regex = "^([3-9]\\d+)\\.\\d{1,2}$"; //| areaGreaterThan30
        boolean check = false;
        double area = 0;
        while (!check) {
            System.out.println("Enter area (area >= 30m2) : ");
            area = CheckValid.checkFloatException();
            if (Pattern.matches(regex, String.valueOf(area))) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong format!Please enter in correct format");
            }
        }
        return area;
    }

    //Phí thuê:  NG  : phí thuê kiểu double --> chỉ giới hạn đến số tiền hàng CHỤC triệu --> làm thế nào?
    public static double rentalFee() {
        String regex = "^([1-9]\\d*)\\.\\d{1,3}$";
        boolean check = false;
        double fee = 0;
        while (!check) {
            System.out.println("Enter rental fee: ");
            fee = CheckValid.checkFloatException();
            if (Pattern.matches(regex, String.valueOf(fee))) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Rental fee is positive number! Please enter in correct format:");
            }
        }
        return fee;
    }
    //số người: ok
    public static int maxNumsPeople() {
        String regex = "^[1-9]|([1][0-9])|(20)$"; // 1-9 | 10-19
        boolean check = false;
        int number = 0;
        System.out.println("Enter the maximum number of people (0 < people <=20): ");
        while (!check) {
            number = CheckValid.checkIntException();
            if (Pattern.matches(regex, String.valueOf(number))) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong Format! Please try again: ");
            }
        }
        return number;
    }

    //kiểu thuê:  ok
    public static String villaStandard() {
        String regex = "^(SVVL)-[a-zA-Z0-9 ]+$";
        boolean check = false;
        String villaStandard = null;
        while (!check) {
            villaStandard = QuickInOut.inputOutput("Enter VILLA STANDARD according to the format:  'SVVL-standardName': ");
            if (Pattern.matches(regex, villaStandard)) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong Format! Please try again: ");
            }
        }
        return villaStandard;
    }

    //so tang:
    public static int numsOfFloors() {
        String regex = "^[1-5]$"; // 1-9 | 10-19
        boolean check = false;
        int numsOfFloors = 0;
        System.out.println("Enter number of floor (floor must be > 0 and <= 5): ");
        while (!check) {
            numsOfFloors = CheckValid.checkIntException();
            if (Pattern.matches(regex, String.valueOf(numsOfFloors))) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong Format! Please try again: ");
            }
        }
        return numsOfFloors;
    }

    public static String houseStandard() {
        String regex = "^(SVHO)-[a-zA-Z0-9 ]+$";
        boolean check = false;
        String houseCode = null;
        while (!check) {
            houseCode = QuickInOut.inputOutput("Enter HOUSE STANDARD according to the format:  'SVHO-standardName': ");
            if (Pattern.matches(regex, houseCode)) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Wrong Format! Please try again: ");
            }
        }
        return houseCode;
    }

    public static String dateOfBirth() {  //ok
        String regex = "^(?=\\d{2}([\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|" +
                "[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
        boolean check = false;
        String birthDate = null;
        while (!check) {
            birthDate = QuickInOut.inputOutput("Enter date of Birth according to format: 'dd/MM/yyy': ");
            //check format:
            if (Pattern.matches(regex, birthDate)) {
                check = checkAge(birthDate);
            } else {
                System.err.println("Wrong format. Please input day according to format: 'dd/MM/yyy'\n" +
                        "And make sure the number of days in the month is valid ");
            }
        }
        return birthDate;
    }

    public static boolean checkAge(String birthDay) {
        //check số tuổi:
        //check số ngày case rieeeng từng tháng:
        String[] arr = birthDay.split("/");
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //tạo pattern. nếu không --> default = ISO_LOCAL_DATE: yyyy-mm-dd  --> báo Ex
        LocalDate birthDate_LocalDay = LocalDate.parse(birthDay, formatter);  //ép kiểu ngày sinh: String--> LocalDay theo định dạng "dd/MM/yyyy"
        LocalDate currentDate = LocalDate.now();  //lấy ngày hiện tại của hệ thống
        int years_gap = Period.between(birthDate_LocalDay, currentDate).getYears();  //lấy tuổi
        int month_gap = Period.between(birthDate_LocalDay, currentDate).getMonths();  //lấy tuổi
        int day_gap = Period.between(birthDate_LocalDay, currentDate).getDays();  //lấy tuổi
        if (years_gap > 18 && years_gap <= 100) {
            System.out.println("ok");
            return true;
        } else if (years_gap == 18 && month_gap >= 0 && day_gap >= 0) {
            System.out.println("ok");
            return true;
        } else {
            System.err.println("Age is out of range: age must be >=18 and <=100 ");
            return false;
        }
    }
}
