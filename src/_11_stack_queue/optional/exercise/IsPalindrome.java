package _11_stack_queue.optional.exercise;

import sun.misc.Queue;

import java.util.Stack;

public class IsPalindrome  {
    public static void main(String[] args) throws InterruptedException {
        String str = "Able was I ere I saw Elba";
        isPalindrome(str);
    }

    public static void isPalindrome(String str) throws InterruptedException {
        //Khởi tạo Stack, add arr[i] vào stack:
        Stack<Character> stack = new Stack<Character>();
        //Khởi tạo Queue, add arr[i] vào Queue:
        Queue<Character> queue = new Queue<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.toUpperCase().charAt(i));
            queue.enqueue(str.toUpperCase().charAt(i));
        }
        compareStackAndQueue(stack, queue, str);
    }

    public static void compareStackAndQueue(Stack<Character> stack, Queue<Character> queue, String str) throws InterruptedException {
        //so sánh từng cặp element của Queue-Stack:
        boolean check = false;
        for (int i = 0; i < str.length() / 2; i++) {
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
