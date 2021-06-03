package _01_introduce_java.practice;

import java.util.Scanner;

public class Th7Bmi {
    public static void main(String[] args) {
        double weight,height,bmi;
        Scanner inputData = new Scanner(System.in);

        System.out.println("Enter weight: ");
        weight = inputData.nextFloat();

        System.out.println("Enter weight: ");
        height = inputData.nextFloat();

        bmi = weight/(height*height);
        System.out.println("BMI = " + weight/(height*height));  // Math.pow (cơ số, số mữ)

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi <= 25.0) {
            System.out.println("Normal");
        } else if (bmi <= 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
