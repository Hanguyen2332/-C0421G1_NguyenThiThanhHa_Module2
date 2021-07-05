package furamaResort.utils;

import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ValidateInputData {
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
            villaCode = QuickInOut.inputOutput("Enter villa service code: ");
            if (Pattern.matches(regex, villaCode)) {
                check = true;
                System.out.println("ok");
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
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
            } else {
                System.err.println("Please enter room standard according to the format: 'SVRO-standardName' ");
            }
        }
        return roomCode;
    }

    public static String dateOfBirth() {  //ok
        String regex = "^((0?[1-9])|([1-2][0-9])|([3][01]))/((0?[1-9])|([1][012]))/(\\d{4})$";  //năm thường
        boolean check = false;
        String birthDate = null;
        while (!check) {
            birthDate = QuickInOut.inputOutput("Enter date of Birth: ");
            //check format:
            if (Pattern.matches(regex, birthDate)) {
                //check số ngày case rieeeng từng tháng:
                String[] arr = birthDate.split("/");
                int day = Integer.parseInt(arr[0]);
                int month = Integer.parseInt(arr[1]);
                int year = Integer.parseInt(arr[2]);
                switch (month) {
                    case 2:
                        if (day == 29 && !isLeapYear(year)) {
                            System.err.println(arr[2] + " is NOT a Leap Year, February has only 28 days! Please enter again ");
                        } else if (day == 30 || day == 31){
                            System.err.println("February has 28 days or 29 days");
                        }else {
                            //check số tuổi:
                            check = checkAge(birthDate);
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (day == 31) {
                            System.err.println(arr[2] + " does NOT has 31 days! Please enter again: ");
                        } else {
                            check = checkAge(birthDate);
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 12:
                        check = checkAge(birthDate);
                        break;
                }
            } else {
                System.err.println("Wrong format! Please enter Date Of Birth according to the format: 'dd/mm/yyyy'");
            }
        }
        return birthDate;
    }

    public static boolean checkAge(String birthDay) {
        //check số tuổi:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //tạo pattern. nếu không --> default = ISO_LOCAL_DATE: yyyy-mm-dd  --> báo Ex
        LocalDate birthDate_LocalDay = LocalDate.parse(birthDay, formatter);  //ép kiểu ngày sinh: String--> LocalDay theo định dạng "dd/MM/yyyy"
        LocalDate currentDate = LocalDate.now();  //lấy ngày hiện tại của hệ thống
        int currentAge = Period.between(birthDate_LocalDay, currentDate).getYears();  //lấy tuổi
        if (18 <= currentAge && currentAge <= 100) {
            System.out.println("ok");
            return true;
        } else {
            System.err.println("Age is out of range: age must be >=18 and <=100 ");
            return false;
        }
    }

    //check năm nhuận:
    public static boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;
        if (isDivisibleBy4) {
            if (isDivisibleBy100) {
                if (isDivisibleBy400) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
