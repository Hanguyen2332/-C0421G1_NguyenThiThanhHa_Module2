package _11_stack_queue.excercise;

import java.util.Arrays;
import java.util.Stack;

public class Bt1ReverseArrayByStack{
    public static void main(String[] args) {
        //khởi tạo stack:
        Stack <Integer>stack = new Stack<Integer>();
        //khởi tạp mảng cần reverse:
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        //push phần tủ sang stack:
        for(int i = 0; i<arr.length;i++) {
            stack.push(arr[i]);
        }
        System.out.println("array after push into Stack: " + Arrays.toString(arr));
        //pop từ stack về lại mảng, reverse:
        for(int i = 0; i<arr.length;i++) {
            arr[i] =  stack.pop();
        }
        System.out.println("array after pop from Stack: " + Arrays.toString(arr));
    }
}
