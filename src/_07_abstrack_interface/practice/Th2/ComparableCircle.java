package _07_abstrack_interface.practice.Th2;

import _06_inheritance.practice.Circle;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> { //<ComparableCircle> : tên Class của các đối tượng cần so sánh với nhau
    //tạo 3 constructor
    public ComparableCircle() { }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    //ghi đè method compareTo() của Interface Comparable
    @Override
    public int compareTo(ComparableCircle o) { //vietsub: so sánh ĐỐI TƯỢNG GỌI HÀM ... với đối tượng THAM SỐ truyền vào.
        if (super.getRadius() > o.getRadius()) {  //so sánh theo tiêu chí: radius
            return 1;
        } else if (super.getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
//    @Override
//    public int compareTo(ComparableCircle o) {
//        return this.getRadius().compareTo(o.getRadius());   //tại sao lại báo lỗi?????
//    }
//}
