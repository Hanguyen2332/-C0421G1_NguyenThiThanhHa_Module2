package _04_class_object.excercise;

import java.util.Scanner;

public class BtAnhTrung3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Chương trình quản lý sinh viên");
        Student[] student = new Student[50];
        do {
            System.out.println("Menu chương trình: \n" +
                    "1. Xem danh sách sinh viên\n" +
                    "2. Xóa sinh viên\n" +
                    "3. Chỉnh sửa thông tin sinh viên\n" +
                    "4. Thêm mới sinh viên\n" +
                    "5. Thoát chương trình\n" +
                    "Chọn chức năng muốn sử dụng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    //gọi hàm 1
                    displayStudentList(student);
                    break;
                case 2:
                    //gọi hàm 2
                    deleteStudent(student);
                    break;
                case 3:
                    //gọi hàm 3
                    editStudentInfo(student);
                    break;
                case 4:
                    //gọi hàm 4
                    addNewStudent(student);
                    break;
                case 5:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Chọn nhầm?Chọn lại đi!");
            }
        } while (true);
    }

    //hàm 1:
    public static void displayStudentList(Student[] student) {
        for (Student element : student) {
            if (element != null) {
                System.out.println(element);
            }
        }
    }

    //hàm 2:
    public static void deleteStudent(Student[] student) {
        int idDeleteStudent = Integer.parseInt(inputOutput("Nhập ID sinh viên muốn xóa: "));
        for (int i = 0; i < student.length; i++) {
            if (idDeleteStudent == (student[i].getId())) {  //tại sao bài anh Trung: deleteStudent.equals(student[i])--> vần chạy đc Không lỗi??
                student[i] = null;
                break;
            }
        }
    }

    //hàm 3:
    public static void editStudentInfo(Student[] student) {
        int idEditStudent = Integer.parseInt(inputOutput("Nhập ID sinh viên muốn chỉnh sửa:"));
        for (int i = 0; i < student.length; i++) {
            if (idEditStudent == student[i].getId()) {
                //set ID:
                System.out.println("Vui lòng nhập ID mới: ");
                int id = Integer.parseInt(sc.nextLine());
                student[i].setId(id);
                //set Name:
                System.out.println("Vui lòng nhập TÊN mới: ");
                String name = sc.nextLine();
                student[i].setName(name);
                //set tuổi
                System.out.println("Vui lòng nhập TUỔI mới: ");
                int age = Integer.parseInt(sc.nextLine());   // NOTE: Lệnh sc.nextLine(): nếu đặt SAU sc.nextInt()--> sẽ bị lỗi KHÔNG HIỂN THỊ
                student[i].setAge(age);                     //FIX: sửa thành: Integer.parseInt(sc.nextLine())
                //set địa chỉ
                System.out.println("Vui lòng nhập ĐỊA CHỈ mới: ");
                String address = sc.nextLine();
                student[i].setAddress(address);
                break;
            }
        }
    }

    //hàm 4:
    public static void addNewStudent(Student[] student) {
        System.out.println("Vui lòng nhập ID sinh viên mới: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập TÊN sinh viên mới: ");
        String name = sc.nextLine();
        System.out.println("Vui lòng nhập TUỔI sinh viên mới: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập ĐỊA CHỈ sinh viên mới: ");
        String address = sc.nextLine();                             //TẠI SAO khi Runtime lại mất dòng này?
        Student newStudent = new Student(id, name, age, address);
        for (int i = 0; i < student.length; i++) {
            if ((student[i] == null)) {
                student[i] = newStudent;
                break;
            }
        }
    }

    public static String inputOutput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}


