package _03_array_method.practice;

import java.util.Scanner;

public class Th1ReverseArray {
    public static void main(String[] args) {
        //khai báo mảng
        Scanner inputElement = new Scanner(System.in);
        int[] arr = new int[7];
        //Khởi tạo mảng:
        for (int i = 0; i < arr.length; i++) {
            System.out.println("input element " + i);
            arr[i] = inputElement.nextInt();
        }
        System.out.println("array before reverse: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        //reverse mảng
        int first = 0;
        int last = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
        //in mảng
        System.out.println("\n array after reverse: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
