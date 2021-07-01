package _19_string_regex.practice;

import java.util.regex.Pattern;

public class Th2ValidateAccount {
    public static void main(String[] args) {
        String[] validate = {"123abc_","_abc123", "______", "123456","abcdefg"};
        String[] invalidate = {".@","12345", "1234_", "abcde "};

        System.out.println("----------test valid Account------------");
        for (String value: validate) {
            System.out.println(value + " : " + validateAccount(value));
        }
        System.out.println("----------test invalid Account------------");
        for (String value: invalidate) {
            System.out.println(value + " : " + validateAccount(value));
        }

    }
    public static boolean validateAccount(String string) {
        String regex = "^[a-z0-9_]{6,}$";
        return Pattern.matches(regex,string);
    }
}
