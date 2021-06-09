package _06_inheritance.excercise;

import java.util.Arrays;

public class Bt2Point3D extends Bt2Point2D {
    private float z = 0.0f;

    public Bt2Point3D() {
    }

    public Bt2Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = {super.getX(), super.getY(), getZ()};  //Làm sao để kế thừa cả mảng getXY mà không lỗi?
        return arr;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "Bt2Point3D (" + super.toString() + " z= " + this.z + ")";
    }
}

class TestPoint3D {
    public static void main(String[] args) {
        //default
        Bt2Point3D point3D_1 = new Bt2Point3D();
        System.out.println(point3D_1.toString());
        point3D_1.setXYZ(2, 4, 6);
        System.out.println("XYZ= " + Arrays.toString(point3D_1.getXYZ()));
        System.out.println();
        //constructor(tham số):
        Bt2Point3D point3D_2 = new Bt2Point3D(3, 1.5f, 5);
        System.out.println(point3D_2.toString());
        point3D_2.setX(7);
        System.out.println("XYZ= " + Arrays.toString(point3D_2.getXYZ()));
    }
}
