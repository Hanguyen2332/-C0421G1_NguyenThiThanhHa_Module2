package furamaResort.libs;

import java.util.Scanner;

public class QuickInOut {
    static Scanner sc = new Scanner(System.in);
    public static String inputOutput(String massage) {
        System.out.println(massage);
        return sc.nextLine();
    }
}
