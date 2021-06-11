package _07_abstrack_interface.excercise.Bt1.shape;

import _07_abstrack_interface.excercise.Bt1.Resizeable;
import _07_abstrack_interface.excercise.Bt2.Colorable;

public class Square extends Shape implements Resizeable, Colorable {  //1 class implements 2 Interface
    double size;

    public Square(double size) {
        this.size = size;
    }

    //ghi đè getArea() của cha Shape
    public String getArea() {
        return "Square area = " + this.size * this.size;
    }

    //ghi đè resize() của interface Resizeable:
    @Override
    public void resize(double percent) {
        this.size += (percent / 100) * this.size;
    }
    //ghi đè howToColor() của interface Colorable:
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "Square{ size=" + size + '}';
    }
}
