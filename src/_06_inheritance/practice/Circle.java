package _06_inheritance.practice;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {  //NOTE: muốn con tạo đc Cunstructor rỗng --> cha cũng phảu có Cunstructor rỗng --> nếu không --> lỗi compile
    }                   //NHƯNG: vì sao???


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
        //hoặc:
        //super.setColor(color);
        //super.setFilled(filled);
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }
    public double getPerimeter () {
        return this.radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + this.radius + " which is a subclass of " + super.toString();
    }
}
class TestCirle {
    public static void main(String[] args) {
        //khởi tạo đối tượng bằng cunstructor():
        Circle myCircle1 = new Circle();
        System.out.println("Radius = " + myCircle1.getRadius());
        System.out.println("Area = " + myCircle1.getArea());
        System.out.println("Perimeter = " + myCircle1.getPerimeter());
        System.out.println(myCircle1.toString());
        //khởi tạo đối tượng bằng cunstructor(radius):
        System.out.println();
        Circle myCircle2 = new Circle(5);
        System.out.println("Radius = " + myCircle2.getRadius());
        System.out.println("Area = " + myCircle2.getArea());
        System.out.println("Perimeter = " + myCircle2.getPerimeter());
        System.out.println(myCircle2.toString());
        //khởi tạo đối tượng bằng cunstructor(3 tham số):
        System.out.println();
        Circle myCircle3 = new Circle("red",false,3);
        System.out.println("Radius = " + myCircle3.getRadius());
        System.out.println("Area = " + myCircle3.getArea());
        System.out.println("Perimeter = " + myCircle3.getPerimeter());
        System.out.println(myCircle3.toString());


    }

}

