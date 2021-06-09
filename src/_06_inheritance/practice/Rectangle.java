package _06_inheritance.practice;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);  //thừa kế 2 thuộc tính của cha SHAPE
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return this.length*this.width;
    }
    public double getPerimeter () {
        return (this.length + this.width)*2;
    }
    @Override
    public String toString() {
        return "A Rectangle with width = " + this.width + " and length = " + this.length + ", which is a subclass of " + super.toString();
    }
}
class TestRectangle {
    public static void main(String[] args) {
        //khởi tạo đối tượng bằng cunstructor():
        Rectangle myRectangle1 = new Rectangle();
        System.out.println(myRectangle1.toString());
        System.out.println("width = " + myRectangle1.getWidth());
        System.out.println("length = " + myRectangle1.getLength());
        System.out.println("Area = " + myRectangle1.getArea());
        System.out.println("Perimeter = " + myRectangle1.getPerimeter());

//        //khởi tạo đối tượng bằng cunstructor(radius):
        System.out.println();
        Rectangle myRectangle2 = new Rectangle(2,4);
        System.out.println(myRectangle2.toString());
        System.out.println("width = " + myRectangle2.getWidth());
        System.out.println("length = " + myRectangle2.getLength());
        System.out.println("Area = " + myRectangle2.getArea());
        System.out.println("Perimeter = " + myRectangle2.getPerimeter());
//        //khởi tạo đối tượng bằng cunstructor(3 tham số):
        System.out.println();
        Rectangle myRectangle3 = new Rectangle("red",true,3,5);
        System.out.println(myRectangle3.toString());
        System.out.println("width = " + myRectangle3.getWidth());
        System.out.println("length = " + myRectangle3.getLength());
        System.out.println("Area = " + myRectangle3.getArea());
        System.out.println("Perimeter = " + myRectangle3.getPerimeter());
        }
}
