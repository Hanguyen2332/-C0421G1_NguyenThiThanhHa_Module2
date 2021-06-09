package BtAnhTrung;
/*Mục tiêu update:
1.luyện tập tính chất Inheritance --> tạo lớp cha-Person, 2 lớp con: Student & Teacher
2.Tạo mảng Person[] person, khởi tạo các element gồm cả object của Student & Teacher,
3. luyện tập Implicit casting--> khởi tạo mảng
4. luyện tập Explicit casting--> in ra method "study" của các phần tử kiểu Student.
*/

import java.awt.event.PaintEvent;
import java.util.Scanner;

public class StudentManagement5 {

    static Scanner sc = new Scanner(System.in);
    public static Person[] person;

    static {
        person = new Person[50];
        person[0] = new BtAnhTrung.Student(11, "Diệp", 26, "Cẩm Lệ", "C0421G1");
        person[1] = new BtAnhTrung.Student(22, "Nhật", 24, "Sơn Trà", "C0421G1");
        person[2] = new BtAnhTrung.Student(44, "Phục", 21, "Hải Châu", "C0421G1");
        person[3] = new Teacher(44, "Linh", 30, "Điện Biên", "Toán");
        person[4] = new Teacher(55, "Quân", 30, "Lào Cai", "Vật lý");

    }

    public static void main(String[] args) {

        System.out.println("Chương trình quản lý person");
//        _04_class_object.excercise.Student[] student = new _04_class_object.excercise.Student[50];
        do {
            System.out.println("Menu chương trình: \n" +
                    "1. Xem danh sách sinh viên\n" +
                    "2. Xem danh sách GIÁO VIÊN\n" +
                    "3. Xóa sinh viên\n" +
                    "4. Chỉnh sửa thông tin sinh viên\n" +
                    "5. Thêm mới sinh viên\n" +
                    "6. Thoát chương trình\n" +
                    "Chọn chức năng muốn sử dụng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    //gọi hàm 1
                    displayStudentList(person);
                    break;
                case 2:
                    //gọi hàm 2
                    displayTeacherList(person);
                    break;
                case 3:
//                    //gọi hàm 3
                    deleteStudent(person);
                    break;
                case 4:
                    //gọi hàm 4
                    editStudentInfo(person);
                    break;
                case 5:
                    //gọi hàm 5
                    addNewStudent(person);
                    break;
                case 6:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Chọn nhầm?Chọn lại đi!");
            }
        } while (true);
    }

    //hàm 1:
    public static void displayStudentList(Person[] person) {
        for (Person element : person) {
            if (element instanceof BtAnhTrung.Student) {
                System.out.println(element + "\t");
                ((Student)element).study();
            }
        }
    }
    //hàm 2:

    public static void displayTeacherList(Person[] person) {
        for (Person element : person) {
            if (element instanceof Teacher) {
                System.out.println(element + "\t");
            }
        }
    }

    //hàm 3:
    public static void deleteStudent(Person[] person) {
        int idDeleteStudent = Integer.parseInt(inputOutput("Nhập ID sinh viên muốn xóa: "));
        for (int i = 0; i < person.length; i++) {
            if (person[i] instanceof Student && idDeleteStudent == person[i].getId()) {
                person[i] = null;
                break;
            } else {
                System.out.println("NOT found this student!");
            }
        }
    }

  //hàm 4:
    public static void editStudentInfo(Person[] person) {
        int idEditStudent = Integer.parseInt(inputOutput("Nhập ID sinh viên muốn chỉnh sửa:"));
        for (int i = 0; i < person.length; i++) {
            if (person[i] instanceof Student && idEditStudent == person[i].getId()) {
                //set ID:
                int id = Integer.parseInt(inputOutput("Vui lòng nhập ID mới: "));
                person[i].setId(id);
                //set Name:
                String name = inputOutput("Vui lòng nhập TÊN mới: ");
                person[i].setName(name);
                //set tuổi
                int age = Integer.parseInt(inputOutput("Vui lòng nhập TUỔI mới: "));
                person[i].setAge(age);
                //set địa chỉ
                String address = inputOutput("Vui lòng nhập  ĐỊA CHỈ mới: ");
                person[i].setAddress(address);
                break;
            } else {
                System.out.println("NOT found this student!");
            }
        }
    }

    //
    //hàm 5:
    public static void addNewStudent(Person[] person) {
        int id = Integer.parseInt(inputOutput("Vui lòng nhập ID sinh viên mới: "));
        String name = inputOutput("Vui lòng nhập TÊN sinh viên mới: ");
        int age = Integer.parseInt(inputOutput("Vui lòng nhập TUỔI sinh viên mới: "));
        String address = inputOutput("Vui lòng nhập  ĐỊA CHỈ sinh viên mới: ");
        String studentClass = inputOutput("Vui lòng nhập TÊN LỚP sinh viên mới: ");
        Person newStudent = new Student(id, name, age, address, studentClass);
        for (int i = 0; i < person.length; i++) {
            if ((person[i] == null)) {
                person[i] = newStudent;
                break;
            }
        }
    }

    public static String inputOutput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}



