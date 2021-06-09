package _06_inheritance.excercise;

import javax.imageio.stream.ImageInputStream;

public class Bt1Cylinder extends Bt1Circle {
    private double height;

    public Bt1Cylinder() {
    }

    public Bt1Cylinder(double height) {
        this.height = height;
    }

    public Bt1Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {   // V = π. r2. h   thể tích
        return super.getArea()*this.height;
    }
    public double getAroundArea() {   //S = 2. Π.R.H  S_xq
        return super.getPerimeter()*this.height;
    }
    public double getBaseArea() {   //S = 2.Π.R2   S_2đáy
        return super.getArea()*2;
    }
    public double getWholeArea() {   //S =  S_đáy + S_xq
        return this.getAroundArea()+this.getBaseArea();
    }
    @Override
    public String toString() {
        return "A Cylinder with height = " + this.height + ", which is a subclass of " + super.toString();
    }
}
class TestCylinder {
    public static void main(String[] args) {
        //constructor(height):
        Bt1Cylinder cylinder1 = new Bt1Cylinder(4);
        System.out.println(cylinder1.toString());
        System.out.println("V = " + cylinder1.getVolume());
        System.out.println("Sxq = " + cylinder1.getAroundArea());
        System.out.println("S_base = " + cylinder1.getBaseArea());
        System.out.println("S_whole = " + cylinder1.getWholeArea());
//constructor(height,):
        System.out.println();
        Bt1Cylinder cylinder2 = new Bt1Cylinder(2,"green",5);
        System.out.println(cylinder2.toString());
        System.out.println("V = " + cylinder2.getVolume());
        System.out.println("Sxq = " + cylinder2.getAroundArea());
        System.out.println("S_base = " + cylinder2.getBaseArea());
        System.out.println("S_whole = " + cylinder2.getWholeArea());
    }
}
