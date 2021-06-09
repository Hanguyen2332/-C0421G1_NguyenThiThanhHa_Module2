package _06_inheritance.excercise;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

class Bt3MoveablePoint extends Bt3Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public Bt3MoveablePoint() {
    }

    public Bt3MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Bt3MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {   //tại sao hiện chữ xanh???
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{this.xSpeed, this.ySpeed};
    }

    @Override
    public String toString() {
        return super.toString() + ", speed = (" + this.xSpeed + ", " + this.ySpeed + ")";
    }

    public Bt3MoveablePoint move() {
        this.setX(super.getX() + this.getXSpeed());
        this.setY(super.getY() + this.getYSpeed());
        return this;
    }
}

class TestMoveAblePoint {
    public static void main(String[] args) {
        Bt3MoveablePoint movePoint = new Bt3MoveablePoint(20, 30);
        System.out.println(movePoint.toString());
        movePoint.setXY(5, 7);
        System.out.println("xy = " + Arrays.toString(movePoint.getXY()));
        System.out.println("move point: " + movePoint.move());
        //NOTE: hàm move: return "this" ==> return ID của chính object : "new Bt3MoveablePoint(20,30)" này (đang được biến movePoint đang tham chiếu tới)
        //kết quả trả về: đáng lẽ là "ID của object", nhưng method toString đã bị cải biên --> trả về nội dung cải biên trong method toString: x,y,xSpeed,ySpeed
    }
}