package _07_abstrack_interface.practice.Th3;

import _06_inheritance.practice.Circle;

import java.util.Comparator;

public class CircleComparatorByRadius implements Comparator<Circle> { //<Circle>: tên Class chứa các object cần sắp xếp
    //    @Override                                                         //CircleComparatorByRadius: tên class - cũng là tên TIÊU CHÍ để sắp xếp
//    public int compare(Circle o1, Circle o2) {
//        if(o1.getRadius() > o2.getRadius()) {
//            return 1;
//        }else if (o1.getRadius() < o2.getRadius()) {
//            return -1;
//        }else {
//            return 0;
//        }
//    }
//}
    @Override
    public int compare(Circle o1, Circle o2) {
        return (int) (o2.getRadius() - o1.getRadius());  //Tại sao sắp xếp theo thứ tự giảm dần k đc?
    }
}

