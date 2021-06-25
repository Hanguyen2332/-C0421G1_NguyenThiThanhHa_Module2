package _15_exception.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //nhap index:
        System.out.println("please enter index: ");
        int index = sc.nextInt();
        //nhap index, cho try bọc ngoài code --> bắt exception
        try {
            createRandom(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("index is INVALID.Array length: %d", 100);
        }
    }

    public static void createRandom(int index) {
        int[] arr = new int[100];
        //khoi tao value:
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) Math.floor(Math.random() * 200);
        }
        System.out.println("Array: "+ Arrays.toString(arr));
        System.out.printf("element at index %d is %d ", index,arr[index]);
    }
}
