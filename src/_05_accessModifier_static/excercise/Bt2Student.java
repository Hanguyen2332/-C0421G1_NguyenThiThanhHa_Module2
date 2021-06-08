package _05_accessModifier_static.excercise;

class Bt2Student {
    private String name = "John";
    private String classes = "C02";

    public Bt2Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}

class TestStudent {
    public static void main(String[] args) {
        Bt2Student student = new Bt2Student();
        student.setName("Anna");
        student.setClasses("C04");
    }
}
