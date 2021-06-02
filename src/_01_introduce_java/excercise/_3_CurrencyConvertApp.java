package _01_introduce_java.excercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _3_CurrencyConvertApp {
    public static void main(String[] args) {
        Scanner inputAmount = new Scanner(System.in);
        System.out.println("Enter USD amount: ");
        float usd = inputAmount.nextFloat();
        float rate = 23000;
        DecimalFormat formatCurrency = new DecimalFormat();
        System.out.println("Exchange rate today: " + formatCurrency.format(rate) + "VND");
        float vnd = usd*rate;
        System.out.println("VND = " + formatCurrency.format(vnd) + "VND");
    }
}
