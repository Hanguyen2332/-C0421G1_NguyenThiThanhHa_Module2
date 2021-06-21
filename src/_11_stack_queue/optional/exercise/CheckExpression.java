package _11_stack_queue.optional.exercise;

import java.util.Scanner;
import java.util.Stack;

public class CheckExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter expression");
        String expression = sc.nextLine();
        System.out.println(isTrueExpression(expression));
    }

    public static boolean isTrueExpression(String expression) {
        //chuyển chuỗi --> mảng
        String[] arr = expression.split("");
        //Khởi tạo 2 biến Stack: left chứa ngoặc trái, right chứa ngoặc phải
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                left.push(arr[i]);
            } else if (arr[i].equals(")")) {
                if (left.empty()) {  // vì biểu thức xuất hiện dấu ) mà chưa có dấu (  --> return luôn, không cần xét tiếp.
                    return false;
                } else {
                    right.push(arr[i]);
                }
            }
        }
        if (left.size() == right.size()) { //nếu số lượng ngoặc trái = số lượng ngoặc phải ==> true
            return true;
        } else {
            return false;
        }
    }
}