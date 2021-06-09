package _06_inheritance.excercise;

public class Bt3Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Bt3Point() {
    }

    public Bt3Point(float x, float y) {
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
        float[] arr = {this.x, this.y};  //trả về mảng float
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}
