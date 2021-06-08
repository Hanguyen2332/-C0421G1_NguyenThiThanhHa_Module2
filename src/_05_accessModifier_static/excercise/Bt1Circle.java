package _05_accessModifier_static.excercise;

import javafx.scene.shape.Circle;

public class Bt1Circle {
    private double radius = 1.0;
    private String color = "red";
    public Bt1Circle() {  // để default cho method/constructor dc K? Khuyến cáo nên dùng gì?
    }
    public Bt1Circle(double r){
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(this.radius,2)*Math.PI;
    }
}
class TestCircle {
    public static void main(String[] args) {
        Bt1Circle myCircle = new Bt1Circle(3);
        System.out.println(myCircle.getRadius());
        System.out.println(myCircle.getArea());
    }
}
