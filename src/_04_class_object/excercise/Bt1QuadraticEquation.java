package _04_class_object.excercise;

public class Bt1QuadraticEquation {
    private double a;
    private double b;
    private double c;

    Bt1QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Bt1QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    double getRoot1() {
        return (-b + Math.pow(this.getDiscriminant(), 0.5)) / 2 * a;
    }

    double getRoot2() {
        return (-b - Math.pow(this.getDiscriminant(), 0.5)) / 2 * a;
    }
}

class Main {
    public static void main(String[] args) {
        Bt1QuadraticEquation equation = new Bt1QuadraticEquation(1, 3, 1);
        System.out.println(equation.toString());
        System.out.println("delta = " + equation.getDiscriminant());
        if (equation.getDiscriminant() > 0) {
            System.out.printf("The equation has TWO roots: r1 = %f and r2 = %f ", equation.getRoot1(), equation.getRoot2());
        } else if (equation.getDiscriminant() == 0) {
            System.out.printf("The equation has ONE root: r = %f ", equation.getRoot1());
        } else {
            System.out.println("The equation has NO real root");
        }
    }
}





