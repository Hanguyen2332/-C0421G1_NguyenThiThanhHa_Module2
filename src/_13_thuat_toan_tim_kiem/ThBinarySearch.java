package _13_thuat_toan_tim_kiem;

import java.util.Scanner;

public class ThBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println("enter element: ");
        int value = sc.nextInt();
        System.out.println("this value at index: " + findElement(arr, value));
    }

    public static int findElement(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if (value < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
