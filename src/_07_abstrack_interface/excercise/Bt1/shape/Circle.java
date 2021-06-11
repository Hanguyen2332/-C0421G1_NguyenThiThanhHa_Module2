package _07_abstrack_interface.excercise.Bt1.shape;

import _07_abstrack_interface.excercise.Bt1.Resizeable;

public class Circle extends Shape implements Resizeable {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    //ghi đè getArea() của cha Shape
    public String getArea() {
        return "Circle Area = " + this.radius * this.radius * Math.PI;
    }

    //ghi đè resize() của interface Resizeable:
    @Override
    public void resize(double percent) {
        this.radius += (percent / 100) * this.radius;
    }

    @Override
    public String toString() {
        return "Circle{ radius=" + radius + '}';
    }
}
