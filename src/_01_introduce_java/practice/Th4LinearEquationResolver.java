package _01_introduce_java.practice;

//Giải phương trinhg bậc nhất
import java.util.Scanner;

public class Th4LinearEquationResolver {
    public static void main(String[] args) {
        //ax+b=c
        double a;
        double b;
        double c;
        double result;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextDouble();
        System.out.println("Enter b: ");
        b = input.nextDouble();
        System.out.println("Enter c: ");
        c = input.nextDouble();
        if (a == 0) {
            if (c == b) {
                System.out.println("phuong trinh VO SO nghiem");
            } else {
                System.out.println("phuong trinh VO nghiem");
            }
        } else {
            result = (c - b) / a;
            System.out.println("Phuong trinh co nghiem x =  " + result);
        }
    }
}
