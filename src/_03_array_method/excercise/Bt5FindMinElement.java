package _03_array_method.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class Bt5FindMinElement {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        findMinElement();
    }

    private static void findMinElement() {
        System.out.println("Enter length of array: ");
        int length = input.nextInt();
        int[] arr = new int[length];
        int minElement = arr[0];
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter element %d ", i);
            arr[i] = input.nextInt();
            if (arr[i] < minElement) {
                minElement = arr[i];
                indexMin = i;
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.printf("MIN element is %d at index %d ", minElement, indexMin);
    }
}
