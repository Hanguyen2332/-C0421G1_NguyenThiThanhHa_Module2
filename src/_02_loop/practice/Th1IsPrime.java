package _02_loop.practice;

import java.util.Scanner;

public class Th1IsPrime {

    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = inputNumber.nextInt();
        boolean check = true;
        if (number < 2) {
            check = false;
        }
        int i = 2;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        if (check) {
            System.out.println(number + " is Prime Number");
        } else {
            System.out.println(number + " is NOT Prime Number");
        }
    }
}
