package _11_stack_queue.optional.isPalindrome;

import sun.misc.Queue;

import java.util.Arrays;
import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) throws InterruptedException {
        String str = "Able was I ere I saw Elba";
        String[] arr = str.split("");
        System.out.println(Arrays.toString(arr));
        //Khởi tạo Stack, add arr[i] vào stack:
        Stack<String> stack = new Stack<String>();
        for (String value : arr) {
            stack.push(value.toUpperCase());
        }
        //Khởi tạo Queue, add arr[i] vào Queue:
        Queue<String> queue = new Queue<String>();
        for (String value : arr) {
            queue.enqueue(value.toUpperCase());
        }
        //so sánh từng cặp element của Queue-Stack:
        boolean check = false;
        for (int i = 0; i < arr.length/2; i++) {
            if (stack.pop().equals(queue.dequeue())) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("this string is a Palindrome");
        } else {
            System.out.println("this string is NOT a Palindrome");
        }
    }
}
