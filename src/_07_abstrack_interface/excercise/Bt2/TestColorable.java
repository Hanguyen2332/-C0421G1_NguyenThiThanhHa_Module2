package _07_abstrack_interface.excercise.Bt2;

import _07_abstrack_interface.excercise.Bt1.shape.Circle;
import _07_abstrack_interface.excercise.Bt1.shape.Rectangle;
import _07_abstrack_interface.excercise.Bt1.shape.Shape;
import _07_abstrack_interface.excercise.Bt1.shape.Square;

public class TestColorable {
    public static void main(String[] args) {
        //tạo mảng hình học
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(5, 8);
        shapes[2] = new Square(10);
        //hien thị:
        for (Shape element: shapes) {
            if (element instanceof Colorable) {  //lúc này đối tượng square có 4 kiểu data: Shape-Square - Colorable-Resizeable đúng k??
                ((Colorable) element).howToColor(); //element: đang được Explicit từ kiểu Shape --> Colorable ?? vậy Shape>Colorable?? --> SAI!
            }else {                              //vì, Shape & Colorable khác loại (class-interface) --> không thể phân biệt lớn bé.
                System.out.println(element.getArea());
            }
        }
    }
}
