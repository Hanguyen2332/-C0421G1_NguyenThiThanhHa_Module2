package _02_loop.practice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Th2CalculateInterest {

    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        float soTienGui = inputData.nextFloat();
        System.out.println("Enter number of months: ");
        int soThangGui = inputData.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        float laiSuat = inputData.nextFloat();
        float tienLai = 0;
        for (int i = 0; i < soThangGui; i++) {
            tienLai += soTienGui * (laiSuat / 100) / 12;
        }
        DecimalFormat stringTienLai = new DecimalFormat();
        System.out.println("tien lai = " + stringTienLai.format(tienLai) + "vnd");
    }
}

