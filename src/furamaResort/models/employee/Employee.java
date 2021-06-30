package furamaResort.models.employee;

import furamaResort.models.Person;

import java.util.Date;

public class Employee extends Person {
    private AcademicLevel academicLevel;// (Trung cấp, Cao đẳng, Đại học và sau đại học)  Note: có thể để data-type: là String or AcademicLevel
    private String position;   //(Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.)
    private float salary;

    public Employee() {
    }

    public Employee(AcademicLevel academicLevel, String position, float salary) {
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String code, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, AcademicLevel academicLevel, String position, float salary) {
        super(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "qualification ='" + academicLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}' + super.toString();
    }
}
