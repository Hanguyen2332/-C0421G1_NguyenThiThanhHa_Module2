package _03_array_method.practice;

import java.util.Scanner;

public class Th3FindMaxElement {

    public static void main(String[] args) {
        int length;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter array asset length: ");
            length = input.nextInt();
            if (length > 20) {
                System.out.println("array length does NOT exceed 20");
            }
        } while (length > 20);
        int[] asset = new int[length];
        int max = asset[0];
        for (int i = 0; i < asset.length; i++) {
            System.out.println("Enter element " + i);
            asset[i] = input.nextInt();
            if (asset[i] > max) {
                max = asset[i];
            }
        }
        for (int element : asset) {
            System.out.print(element + " ");
        }
        System.out.printf("\n the richest person has %d billion dollars  ", max);
    }
}
