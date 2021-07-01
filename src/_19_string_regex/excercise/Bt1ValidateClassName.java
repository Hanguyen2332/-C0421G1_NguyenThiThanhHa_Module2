package _19_string_regex.excercise;

import java.util.regex.Pattern;

public class Bt1ValidateClassName {
    public static void main(String[] args) {
        String[] validate = {"C0318G","A0004H","P1234K"};
        String[] invalidate = {"M0318G","P0323A","CA0123K","C345M","K9876m"};

        System.out.println("----------test valid Account------------");
        for (String value: validate) {
            System.out.println(value + " : " + validateClassName(value));
        }
        System.out.println("----------test invalid Account------------");
        for (String value: invalidate) {
            System.out.println(value + " : " + validateClassName(value));
        }

    }
    public static boolean validateClassName(String string) {
        String regex = "^[CAP][\\d]{4}[GHIKLM]$";
        return Pattern.matches(regex,string);
    }
}
