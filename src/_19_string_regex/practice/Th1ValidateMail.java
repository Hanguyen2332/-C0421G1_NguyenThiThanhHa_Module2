package _19_string_regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Th1ValidateMail {

    public static boolean validateMail(String mail) {
        String regex = "^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$";
        Pattern pattern = Pattern.compile(regex);  //tạo mẫu
        Matcher matcher = pattern.matcher(mail);   //so khớp: mẫu - email nhập vào
        return matcher.find();           //hàm find(): khớp --> return true/ không khớp --> return false    //hàm matches()??
    }
}
