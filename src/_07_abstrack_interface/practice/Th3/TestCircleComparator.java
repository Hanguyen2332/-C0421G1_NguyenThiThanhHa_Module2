package _07_abstrack_interface.practice.Th3;

import _06_inheritance.practice.Circle;
import _07_abstrack_interface.practice.Th2.ComparableCircle;

import java.util.Arrays;
import java.util.Comparator;

public class TestCircleComparator {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new ComparableCircle(4);
        circles[2] = new ComparableCircle("green",true,0.75);
        //trước sắp xếp
        System.out.println("Pre-sorted:");
        for (Circle element : circles) {
            System.out.println(element);
        }
        Comparator compareCircle = new CircleComparatorByRadius();
        Arrays.sort(circles,compareCircle); // Arrays.sort(array,Comparator): sắp xếp các phần tử của kiểu Comparator
        //in kết quả:
        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
