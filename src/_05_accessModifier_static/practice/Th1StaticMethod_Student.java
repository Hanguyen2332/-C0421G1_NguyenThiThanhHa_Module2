package _05_accessModifier_static.practice;

class Th1StaticMethod {
    private int id;
    private String name;
    private static String university = "DN university";

    //hàm khởi tạo:
    Th1StaticMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //tạo phương thức static-thay đổi value biến static university:
    static void change() {
        university = "DN Foreign Language Studies";
    }
    //hiển thị

    @Override
    public String toString() {
        return "Th1StaticMethod{" + "id = " + id + ", name = " + name + ", " + university + "}";
    }
}
class TestTh1 {
    public static void main(String[] args) {
        //CHƯA gọi hàm static change  --> biến university = "DN university"
        Th1StaticMethod test1 = new Th1StaticMethod(111,"Lụa");
        Th1StaticMethod test2 = new Th1StaticMethod(222,"Lê");
        Th1StaticMethod test3 = new Th1StaticMethod(333,"Loan");
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString() + "\n");
        //GỌI hàm static change  --> biến university = "DN Foreign Language Studies"
        Th1StaticMethod.change();
        Th1StaticMethod test4 = new Th1StaticMethod(444,"Tũn");
        Th1StaticMethod test5 = new Th1StaticMethod(555,"Tí");
        Th1StaticMethod test6 = new Th1StaticMethod(666,"Tèo");
        System.out.println(test4.toString());
        System.out.println(test5.toString());
        System.out.println(test6.toString());
    }
}
