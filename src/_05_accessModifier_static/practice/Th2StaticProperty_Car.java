package _05_accessModifier_static.practice;

public class Th2StaticProperty_Car {
    private int maxSpeed;
    private String color;
    private String maker;
    private static int numberOfCars;   //không cần giá trị khởi tạo = 0, vì default value của kiểu int = 0 rồi.

    public Th2StaticProperty_Car(int maxSpeed, String color, String maker) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.maker = maker;
        numberOfCars++;
    }
    public static void main(String[] args) {
        Th2StaticProperty_Car car1 = new Th2StaticProperty_Car(120,"Orange","TOYOTA");
        System.out.println(Th2StaticProperty_Car.numberOfCars);
        Th2StaticProperty_Car car2 = new Th2StaticProperty_Car(150,"Yellow","VOLVO");
        System.out.println(Th2StaticProperty_Car.numberOfCars);
    }
}

