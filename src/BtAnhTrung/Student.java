package BtAnhTrung;

public class Student extends Person {
   private String studentClass="C0421G1";;

    public Student() {
    }
    public Student(String _class) {
        this.studentClass = _class;
    }

    public Student(int id, String name, int age, String address, String _class) {
        super(id, name, age, address);
        this.studentClass = _class;
    }

    public String get_class() {
        return studentClass;
    }

    public void set_class(String _class) {
        this.studentClass = _class;
    }
    public void study() {
        System.out.println("Đang học IT");
    }
    @Override
    public String toString() {
        return super.toString() + "class = " + this.studentClass;
    }
}

/*Note: this class-Student had been initialized From update 3
-update4: not change
-Update 5: Inheritance from parent-class Person (Inheritance: 1. property: id, name, age, address  2. Method toString())
*/

