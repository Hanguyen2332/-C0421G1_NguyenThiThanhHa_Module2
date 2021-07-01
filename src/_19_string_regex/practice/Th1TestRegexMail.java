package _19_string_regex.practice;

public class Th1TestRegexMail {
    public static void main(String[] args) {
        String[] validate = {"h@outlook.com", "ThanhHa2332@gmail.com", "hantt@codegym.com.vn", "hantt@CODEGYM.com.vn"};
        String[] invalidate = {"123h@outlook.com", "tha%^&2332@gmail.com", "hantt@@@hotmail.com", "hantt@codegym123.com", "ha12@email.edu.com.vn.email"};
        System.out.println("----------test valid mail:------------");
        for (String value : validate) {
            System.out.println(value + " : " + Th1ValidateMail.validateMail(value));
        }
        System.out.println("----------test invalid mail :------------");
        for (String value : invalidate) {
            System.out.println(value + " : " + Th1ValidateMail.validateMail(value));
        }
    }
}

