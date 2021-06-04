package _03_array_method.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class Bt3ConCatArray {
    static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
        int[] arr1 = new int[4];
        int[] arr2 = new int[6];
        conCatArray(arr1,arr2);
    }
    public static void conCatArray(int[]arr1, int[]arr2) {
        int[] arr3 = new int [arr1.length+arr2.length];

        for (int i=0; i<arr1.length;i++) {
                System.out.printf("Enter element %d off arr1 ",i);
                arr1[i] = input.nextInt();//khởi tạo mảng 1
                arr3[i] = arr1[i]; //nhập vào mảng 3;
            }
        System.out.println("\r");
        for (int i=0; i<arr2.length;i++) {
            System.out.printf("Enter element %d off arr2 ",i);
            arr2[i] = input.nextInt();
            arr3[arr1.length+i] = arr2[i];
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
    }
}

