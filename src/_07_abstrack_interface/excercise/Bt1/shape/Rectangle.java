package _07_abstrack_interface.excercise.Bt1.shape;

import _07_abstrack_interface.excercise.Bt1.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //ghi đè getArea() của cha Shape
    public String getArea() {
        return "Rectangle area = " + this.width * this.height;
    }

    //ghi đè resize() của interface Resizeable:
    @Override
    public void resize(double percent) {
        this.width += (percent / 100) * this.width;
        this.height += (percent / 100) * this.height;
    }

    @Override
    public String toString() {
        return "Rectangle{ width=" + width + ", height=" + height + '}';
    }
}
