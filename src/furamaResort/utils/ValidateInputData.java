package furamaResort.utils;

import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateInputData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

////        tên dịch vụ: ok
//        serviceName();

//        //diện tích sd: ok
//        useArea();

//        double rentalFee = 1900055.237;
//        System.out.println(String.valueOf(rentalFee));
//        rentalFee();

////       số người tối đa: ok
//        numberOfPeople();

//        //Villa code:
//        villaCode();

//        //Villa code:
//        villaStandard();

        //floors:
//        numsOfFoors();
        validateAge();

    }

    //mã dịch vụ: đang phải làm 3 method cho 3 mã --> có cách nào gộp chung không?
    public static String villaCode() {
        String regex = "^(SVVL)-[0-9]{4}$";
        boolean check = false;
        String villaCode = null;
        while (!check) {
            villaCode = QuickInOut.inputOutput("Enter villa service code: ");
            if (Pattern.matches(regex, villaCode)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Villa code must be in the format: 'SVVL-XXXX', where X is a number from 0-9");
            }
        }
        return villaCode;
    }
    public static String houseCode() {
        String regex = "^(SVHO)-[0-9]{4}$";
        boolean check = false;
        String houseCode = null;
        while (!check) {
            houseCode = QuickInOut.inputOutput("Enter house code: ");
            if (Pattern.matches(regex, houseCode)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("House code must be in the format: 'SVHO-XXXX', where X is a number from 0-9");
            }
        }
        return houseCode;
    }
    public static String roomCode() {
        String regex = "^(SVRO)-[0-9]{4}$";
        boolean check = false;
        String roomCode = null;
        while (!check) {
            roomCode = QuickInOut.inputOutput("Enter room code: ");
            if (Pattern.matches(regex, roomCode)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Room code must be in the format: 'SVRO-XXXX', where X is a number from 0-9");
            }
        }
        return roomCode;
    }

    //tên dịch vụ: ok
    public static String serviceName() {
        String regex = "^[A-Z][a-zA-Z0-9]+$";
        boolean check = false;
        String name = null;
        while (!check) {
            name = QuickInOut.inputOutput("Enter util name: ");
            if (Pattern.matches(regex, name)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Service name must start with a capital letter . Please enter in correct format!");
            }
        }
        return name;
    }

    //Diện tích sử dụng: ok
    public static float area() {
        String regex = "^([1]\\d{2}\\.\\d{1,2})|([3-9][\\d]\\.\\d{1,2})$"; //areaGreaterThan100 | areaGreaterThan30
        boolean check = false;
        float area = 0;
        while (!check) {
            System.out.println("Enter use area: ");
            area = CheckValid.checkFloatException();
            if (Pattern.matches(regex, String.valueOf(area))) {
                check = true;
                System.out.println("ok");
            }else {
            System.err.println("Area must be greater than 30m2 and less than 200m2. Please enter in correct format");
            }
        }
        return area;
    }

    //Phí thuê:  NG  : phí thuê kiểu double --> chỉ giới hạn đến số tiền hàng CHỤC triệu --> làm thế nào?
    public static double rentalFee() {
        String regex = "^[1-9]+\\.\\d{1,3}$";
        boolean check = false;
        double fee = 0;
        while (!check) {
            System.out.println("Enter rental fee: ");
            fee = CheckValid.checkFloatException();
            if (Pattern.matches(regex, String.valueOf(fee))) {
                check = true;
                System.out.println("ok");
            } else {
                System.err.println("Rental fee positive number! Please enter in correct format:");
            }
        }
        return fee;
    }

    //số người: ok
    public static int maxNumsPeople() {
        String regex = "^[1-9]|([1][0-9])?$"; // 1-9 | 10-19
        boolean check = false;
        int number = 0;
        System.out.println("Enter the maximum number of people: ");
        while (!check) {
            number = CheckValid.checkIntException();
            if (Pattern.matches(regex, String.valueOf(number))) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("The maximum number of people must be > 0 and <= 20. Please try again: ");
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
            villaStandard = QuickInOut.inputOutput("Enter villa standard: ");
            if (Pattern.matches(regex, villaStandard)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Please enter villa standard according to the format:  'SVVL-standardName'");
            }
        }
        return villaStandard;
    }

    //so tang:
    public static int numsOfFoors() {
        String regex = "^[1-5]$"; // 1-9 | 10-19
        boolean check = false;
        int numsOfFoors = 0;
        System.out.println("Enter number of floor: ");
        while (!check) {
            numsOfFoors = CheckValid.checkIntException();
            if (Pattern.matches(regex, String.valueOf(numsOfFoors))) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("The number of floor must be > 0 and <= 5. Please try again: ");
            }
        }
        return numsOfFoors;
    }

    public static String houseStandard() {
        String regex = "^(SVHO)-[a-zA-Z0-9 ]+$";
        boolean check = false;
        String houseCode = null;
        while (!check) {
            houseCode = QuickInOut.inputOutput("Enter house standard: ");
            if (Pattern.matches(regex, houseCode)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Please enter house standard according to the format: 'SVHO-standardName' ");
            }
        }
        return houseCode;
    }
    public static String roomStandard() {
        String regex = "^(SVRO)-[a-zA-Z0-9 ]+$";
        boolean check = false;
        String roomCode = null;
        while (!check) {
            roomCode = QuickInOut.inputOutput("Enter room standard: ");
            if (Pattern.matches(regex, roomCode)) {
                check = true;
                System.out.println("ok");
            }else {
                System.err.println("Please enter room standard according to the format: 'SVRO-standardName' ");
            }
        }
        return roomCode;
    }

    /*viết hàm check năm nhuận:
    1. người dùng nhập date of birth --> if đúng định dạng --> tách chuỗi: split("/") --> lấy ngày sinh (get[1] + lấy năm (get[2]) --> chuyển qua int
    ---> ngày sinh == 29 --> check năm nhuận --> nếu năm nhuận --> báo lỗi "chỉ có 28 ngày".
    public static int isLeapYear(arr.get[2]) {
    // code kiểm tra năm nhuận
    .........
    }
    2. đưa hàm vào validateAge()
    */


    public static String validateAge() {
        String regex = "^((0[1-9])|([1-2][0-9])|([3][01]))/((0[1-9])|([1][012]))/(\\d{4})$";  //năm thường
        boolean check = false;
        String birthDate = null;
        while (!check) {
            birthDate = QuickInOut.inputOutput("Enter date of Birth: ");
            //check format:
            if (Pattern.matches(regex,birthDate)) {
                //check số tuổi:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //tạo pattern. nếu không --> default = ISO_LOCAL_DATE: yyyy-mm-dd  --> báo Ex
                LocalDate birthDate_LocalDay = LocalDate.parse(birthDate,formatter);  //ép kiểu ngày sinh: String--> LocalDay theo định dạng "dd/MM/yyyy"
                LocalDate currentDate = LocalDate.now();  //lấy ngày hiện tại của hệ thống
                int currentAge = Period.between(birthDate_LocalDay,currentDate).getYears();  //lấy tuổi
                if (18<=currentAge && currentAge <=100) {
                    System.out.println("ok");
                    check = true;
                }else {
                    System.err.println("Age is out of range: age must be >=18 and <=100 ");
                }
            }else {
                System.err.println("Wrong format! Please enter Date Of Birth according to the format: 'dd/mm/yyyy'");
            }
        }
        return birthDate;
    }
}
////        String regex2 = "^((0[1-9])|([1][0-9])|([2][0-8])|([3][01])[/])((0[1-9])|([1][012])[/])(\\d{4})$";  //năm nhuận
