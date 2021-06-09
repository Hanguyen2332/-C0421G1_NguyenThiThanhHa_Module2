package BtAnhTrung;

public class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(int id, String name, int age, String address, String subject) {
        super(id, name, age, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " subject = " + this.subject;
    }
}
