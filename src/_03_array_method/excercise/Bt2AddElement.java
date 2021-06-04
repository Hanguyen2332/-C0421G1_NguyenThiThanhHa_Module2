package _03_array_method.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class Bt2AddElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //nhap độ dài mảng
        System.out.print("Enter array length: ");
        int length = input.nextInt();
        int[] arr = new int[length];
        //khai báo phần tử mảng
        System.out.print("Enter number of value: ");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + i);
            arr[i] = input.nextInt();
        }
        System.out.println(" Array before insert: " + Arrays.toString(arr));
        //chèn vào:
        if (n != arr.length) {
            //Nhap index muốn chèn:
            System.out.println("Enter position of new Element: ");
            int addNumIndex = input.nextInt();
            if(addNumIndex < arr.length) {
                //Nhap so muon add
                System.out.println("Enter new Element: ");
                int addNum = input.nextInt();

                for (int i = n; i>=addNumIndex; i--) {
                    arr[i] = arr[i-1];
                }
                arr[addNumIndex] = addNum;
                System.out.println(" Array after insert: " + Arrays.toString(arr));
            } else {
                System.out.println("the position is out of array ");
            }
        } else {
            System.out.println("Array has been full of value! Can NOT add new element! ");
        }
    }
}

