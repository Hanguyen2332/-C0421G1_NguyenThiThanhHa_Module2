package _06_inheritance.excercise;

public class Bt1Circle {
    private double radius = 1.0;
    private String color = "red";

    public Bt1Circle() {
    }

    public Bt1Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }
    public double getPerimeter() {
        return this.radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "Bt1Cylinder {radius = " + radius + ", color= " + color + "}";
    }
////Test Circle:  ok
//    public static void main(String[] args) {
//        Bt1Circle myCircle = new Bt1Circle(3,"red");
//        System.out.println(myCircle.toString());
//        System.out.println(myCircle.getRadius());
//        System.out.println(myCircle.getPerimeter());
//        System.out.println(myCircle.getArea());
//    }
}
