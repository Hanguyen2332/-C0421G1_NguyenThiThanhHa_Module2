package _06_inheritance.practice;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side,side);  //chưa hiểu vì sao kế thừa width -lenght mà lại truyền side vào đc?
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {  //dài = rộng --> chỉ cần lấy rộng
        return getWidth();
    }

    public void setSide(double side) {  //Chỉ truyền vào 1 tham số side ==> dài = rộng ==>vuông
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override

    public String toString() {
        return "A Square with side=" + getSide() + " , which is a subclass of " + super.toString();
    }
}
