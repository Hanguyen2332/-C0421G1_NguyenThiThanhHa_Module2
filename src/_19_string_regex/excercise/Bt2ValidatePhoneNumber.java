package _19_string_regex.excercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt2ValidatePhoneNumber {
    public static void main(String[] args) {
        String[] validate = {"(84)-(0978489648)","(96)-(0986058250)"};
        String[] invalidate = {"(ah)-(0123456789)","(123)-(0123456789)","(1)-(0123456789)","(12)-(5123456789)","(12)-(0123456)"};

        System.out.println("----------test valid Account------------");
        for (String value: validate) {
            System.out.println(value + " : " + validatePhone(value));
        }
        System.out.println("----------test invalid Account------------");
        for (String value: invalidate) {
            System.out.println(value + " : " + validatePhone(value));
        }

    }
public static boolean validatePhone(String phone) {
    String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$"; //note:  Nhập dấu ( --> dùng \\(
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phone);
    return matcher.matches();
}
}
