package _01_introduce_java.excercise;

import java.util.Scanner;

public class Bt1DisplayHello {
    public static void main(String[] args) {
        Scanner inputName = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = inputName.nextLine();
        System.out.println("Hello: " + name);
    }
}
