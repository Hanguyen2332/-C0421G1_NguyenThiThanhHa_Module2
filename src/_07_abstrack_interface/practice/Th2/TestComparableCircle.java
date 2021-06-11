package _07_abstrack_interface.practice.Th2;

import java.util.Arrays;

public class TestComparableCircle {
    public static void main(String[] args) {
        //tạo mảng object "circle"
        ComparableCircle []circle = new ComparableCircle[3];
        circle[0] = new ComparableCircle();
        circle[1] = new ComparableCircle(3);
        circle[2] = new ComparableCircle("green",true,0.75);
        //hiển thị mảng trước khi sắp xếp
        System.out.println("pre-sort: ");
        for (ComparableCircle element: circle) {
            System.out.println(element);
        }
        //sắp xếp mảng theo THUỘC TÍNH bán kính :
        Arrays.sort(circle);   //Hàm Arrays.sort(array): sắp xếp các phần tử của kiểu Comparable
        //hiển thị kết quả:
        System.out.println("After-sorted: ");
        for (ComparableCircle element: circle){
            System.out.println(element);
        }
    }
}
/*NOTE:
            1. TH arr cần sort() là kiểu NGUYÊN THỦY --> chỉ cần Arrays.sort(arr)  --> ok
            2. TH arr cần sort() là kiểu Object, cần sort theo THUỘC TÍNH (bán kính?name?color?) của nó
            --> phải cho Object đó implements interface Comparable và OVERRIDING phương thức "compareTo()"
             */
