package _11_stack_queue.optional.exercise;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        //nhập decimal từ bàn phím:
        Scanner sc =  new Scanner(System.in);
        System.out.println("enter decimal:");
        int decimal = sc.nextInt();
        //khởi tạo stack rỗng:
        Stack<Integer> stack = new Stack<>();
        //chuyển sang hệ nhị phân (%2)
        for (int i = 0; decimal != 0; i++) {
            int value = decimal % 2;
            stack.push(value);
            decimal = decimal / 2;
            if (decimal == 0) {
                value = 0;
                stack.push(value);
            }
        }
        //đọc stack, in kết quả (nối chuỗi)
        String result = "";
        for (int i = 0; stack.size() != 0; i++) {
            result += stack.pop();
        }
        System.out.println("After convert to Binary: " + result);
    }
}
