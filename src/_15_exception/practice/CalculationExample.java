package _15_exception.practice;

import java.util.Scanner;

public class CalculationExample {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //initial new object:
        CalculationExample calc = new CalculationExample();
        //gọi hàm:
        calc.calculate();
    }

    public void calculate() {
        try {
            //input a,b:
            System.out.println("enter number a: ");
            int a = Integer.parseInt(sc.nextLine()); // VD: Nếu nhập "123"--> chuyển thành 123 . Nếu nhập "AC" --> Báo lỗi
            System.out.println("enter number b: ");
            int b = Integer.parseInt(sc.nextLine());
            //hiển hị kết quả
            System.out.println("a+b = " + (a + b));
            System.out.println("a-b = " + (a - b));
            System.out.println("a*b = " + a * b);
            System.out.println("a/b = " + a / b);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format: " + e.getMessage());  //e.getMessage(): hiển thị tin nhắn thông báo cho đối tượng thuộc kiểu lỗi này
        } catch (ArithmeticException e) {  //lỗi chia cho 0
            System.out.println("Arithmetic error: " + e.getMessage());
        }
    }
}
