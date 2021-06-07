package _04_class_object.excercise;

import java.util.Scanner;

public class Bt3Fan {
    static Scanner sc = new Scanner(System.in);

    public static final int SLOW = 1;   // NOTE: access modifier = public --> can access from object!
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;   //tại sao lại là private int -  vì đây là giá trị mặc định --> "private" để không bị thay đổi trực tiếp từ object??
    private boolean on = false; // NOTE: private --> không thể truy cập (bị nhìn thấy trên thanh gợi ý) từ object/ nhưng public & protected:
    private double radius = 5;  // có thể nhìn thấy và thay đổi value trực tiếp từ object = cách: fan2.speed =9;
    private String color = "blue";

    public Bt3Fan() {           // default Constructor
    }

    public Bt3Fan(final int newSpeed, boolean newOn, double newRadius, String newColor) {
        this.speed = newSpeed;
        this.on = newOn;
        this.radius = newRadius;
        this.color = newColor;
    }

    void setSpeed(int newSpeed) {   // không ghi access modifier (pucblic/private...)  --> mặc định là public???
        if (this.on) {
            this.speed = newSpeed;
        } else {
            System.out.println("Fan is off. Do you want to turn it on to use this function?\n" +
                    "1. Yes \n" +
                    "2. Cancel\n" +
                    "Please enter a number");
            int choice = sc.nextInt();
            if (choice == 1) {
                this.turnOn();
                System.out.println("Now speed is " + this.speed + ", Pass by value to continue:\n" +
                        "1. SLOW \n" +
                        "2. MEDIUM \n" +
                        "3. FAST \n" +
                        "Please enter a number");
                int speed = sc.nextInt();
                switch (speed) {
                    case 1:
                        this.setSpeed(SLOW);
                        System.out.println("Completely set up speed!");
                        break;
                    case 2:
                        this.setSpeed(MEDIUM);
                        System.out.println("Completely set up speed!");
                        break;
                    case 3:
                        this.setSpeed(FAST);
                        System.out.println("Completely set up speed!");
                        break;
                    default:
                        System.out.println("This speed does not exist! ");
                        break;
                }
            } else if (choice == 2) {
                System.out.println("speed does not change!");
            }
        }
    }

    int getSpeed() {
        return this.speed;
    }

    void turnOn() {
        if (this.on) {
            System.out.println("Fan is turning ON");
        } else {
            this.on = true;
            System.out.println("Turned ON the fan");
        }
    }

    void turnOff() {
        if (this.on) {
            this.on = false;
            System.out.println("Turned OFF the fan");
        }
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return this.radius;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Fan {" + "Speed = " + speed + "\t Color = " + color + "\t Radius = " + radius + "\t Fan is ON" + "}";
        } else {
            return "Fan {" + "Color = " + color + "\t Radius = " + radius + "\t Fan is OFF" + "}";
        }
    }
}

class Runtime {
    public static void main(String[] args) {
        //Hiển thị dataField mặc định  = đối tượng nặc danh
        System.out.println(new Bt3Fan().toString());   //ok
        //khởi tạo đối tượng Fan 1:
        System.out.println("\n Fan 1: ");
        Bt3Fan fan1 = new Bt3Fan(Bt3Fan.FAST, true, 10, "yellow");
        System.out.println(fan1.toString());          //ok
        fan1.turnOn();
        fan1.turnOff();
        fan1.turnOn();
        fan1.turnOn();                              //ok
        fan1.turnOff();
        fan1.turnOff();
        fan1.turnOn();
        //khởi tạo đối tượng fan 2:
        System.out.println("\n Fan 2:");
        Bt3Fan fan2 = new Bt3Fan(Bt3Fan.MEDIUM, false, 5, "blue");
        System.out.println(fan2.toString());      //OK
        fan2.setColor("red");                     //OK
        System.out.println("Color = " + fan2.getColor());  //OK
        fan2.setRadius(12);                                 //OK
        System.out.println("Radius = " + fan2.getRadius()); //OK
        fan2.turnOn();              // set speed khi đã mở quạt  --> OK
        fan2.setSpeed(Bt3Fan.FAST);
        System.out.println("Speed = " + fan2.getSpeed());
        fan2.turnOff();
        fan2.setSpeed(Bt3Fan.SLOW);  // set speed khi quạt đang tắt  --> OK
        System.out.println("Speed = " + fan2.getSpeed());
    }
}
