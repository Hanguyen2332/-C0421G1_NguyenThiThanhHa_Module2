package _02_loop.practice;

import java.util.Scanner;

public class Th3GreatestCommonDivisors {
    public static void main(String[] args) {
        //VD: ucln (8,9) = 1
        // 8 = 2^3; 9 = 3^3 ==> ucln = 1
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = inputNumber.nextInt();
        System.out.println("Enter b: ");
        int b = inputNumber.nextInt();
        int GreatestCommonDivisor = 1;
        if(a==0 || b==0) {
            GreatestCommonDivisor = Math.abs(a+b);
            System.out.println("the greatest common divisor is: " + GreatestCommonDivisor);
        }
        if (a != 0 && b != 0) {
            for (int i = a; i >= 2; i--) {
                if (a % i == 0 && b % i == 0) {
                    GreatestCommonDivisor = i;
                    break;
                }
            }
            System.out.println("the greatest common divisor is: " + GreatestCommonDivisor);
        }

    }
}