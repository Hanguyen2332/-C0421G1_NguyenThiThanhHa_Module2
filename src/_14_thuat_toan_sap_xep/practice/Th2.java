package _14_thuat_toan_sap_xep.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Th2 {
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
        System.out.println("Array before Bubble sort: " + Arrays.toString(arr));
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] list) {
        boolean needSort = true;
        System.out.println("Declared boolean variable:  needSort = " + needSort);
        for (int i = 0; i < list.length && needSort; i++) {
            needSort = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    System.out.println(" Swap " + list[j] + " with " + list[j - 1]);
                    int temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    needSort = true;
                }
            }
            if (!needSort) {
                System.out.println("this array had been sorted \n");
                break;
            }
            System.out.print("List after the  " + i + " times sort: " + Arrays.toString(list) + "\n");
        }
    }
}

