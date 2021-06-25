package _15_exception.excercise;

import java.util.Scanner;

public class Triangle {
    private float a;
    private float b;
    private float c;

    public Triangle(float a, float b, float c) throws IllegalTriangleException {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a > 0 && b > 0 && c > 0) {
            if ((a + b) > c && (a + c) > b && (c + b) > a) {
                System.out.println("initialization successful!");
            } else {
                throw new IllegalTriangleException("The sum of any two sides must be GREATER than the other side ");
            }
        } else {
            throw new IllegalTriangleException("side of triangle must be greater than 0");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter side a: ");
        float a = sc.nextFloat();
        System.out.println("enter side b: ");
        float b = sc.nextFloat();
        System.out.println("enter side c: ");
        float c = sc.nextFloat();
        try {
            Triangle myTriangle = new Triangle(a, b, c);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }
}
