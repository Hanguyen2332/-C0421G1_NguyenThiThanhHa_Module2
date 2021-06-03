package _01_introduce_java.practice;

import java.util.Scanner;

public class Th3Operator {
    public static void main(String[] args) {
        float weight;
        float height;
        Scanner input = new Scanner(System.in);  //đối tượng mới của lớp Scanner - tên: input, chức năng: lát nữa input data từ bàn phím.
        System.out.println("Enter width: ");
        weight = input.nextFloat();
        System.out.println("Enter height: ");
        height = input.nextFloat();   // gọi phương thức nextFloat của object "input" - trả về 1 số thực ==> input data from keyboard.
        float area = weight*height;
        System.out.println("Rectangle area = " + area);
    }
}
