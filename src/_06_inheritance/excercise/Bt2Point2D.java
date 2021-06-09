package _06_inheritance.excercise;

import java.util.Arrays;

public class Bt2Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Bt2Point2D() {
    }

    public Bt2Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = {this.getX(), this.getY()};  //trả về mảng float
        return arr;
    }

    public void setXY(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

//    public static void main(String[] args) {
    //default
//        Bt2Point2D point2D_1 = new Bt2Point2D ();
//        System.out.println(point2D_1.toString());
//        point2D_1.setXY(2,4);
//        System.out.println("XY = " + Arrays.toString(point2D_1.getXY()));
//        //constructor(tham số):
//        Bt2Point2D point2D_2 = new Bt2Point2D (3,1.5f);
//        System.out.println(point2D_2.toString());
//        point2D_2.setXY(1.5f,5.2f);
//        System.out.println("XY = " + Arrays.toString(point2D_2.getXY()));
//    }
}
