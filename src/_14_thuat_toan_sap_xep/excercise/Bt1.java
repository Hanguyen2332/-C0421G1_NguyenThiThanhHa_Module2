package _14_thuat_toan_sap_xep.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array length: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("initialize values of array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element " + i);
            arr[i] = sc.nextInt();
        }
        //display the array:
        System.out.println("Array before sort: " + Arrays.toString(arr));
        insertionSort(arr);
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentValue = list[i];
            int index = i;
            System.out.println("currentValue: " + currentValue + " at index: " + index);
            //dich mang:
            while (index > 0 && currentValue < list[index - 1]) {
                list[index] = list[index - 1];
                index--;
            }
            //chen:
            list[index] = currentValue;
            System.out.println("List after the  " + i + " times sort: " + Arrays.toString(list) + "\n");
        }
    }
}
