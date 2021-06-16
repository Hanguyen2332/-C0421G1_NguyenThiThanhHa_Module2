package BtAnhTrung;

import java.util.Scanner;

public class StudentManagement2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Chương trình quản lý sinh viên");
        String[] student = new String[50];
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
    public static void displayStudentList(String[] student) {
        for (String element : student) {
            if (element != null) {
                System.out.println(element);
            }
        }
    }

    //hàm 2:
    public static void deleteStudent(String[] student) {
        String deleteStudent = inputOutput("Nhập tên sinh viên muốn xóa: ");
        for (int i = 0; i < student.length; i++) {
            if (deleteStudent.equals(student[i])) {
                student[i] = null;
                break;
            }
        }
    }

    //hàm 3:
    public static void editStudentInfo(String[] student) {
        String tenSinhVien = inputOutput("Nhập tên sinh viên muốn chỉnh sửa:");
        String newInfor = inputOutput("Vui lòng nhập thông tin mới: ");
        for (int i = 0; i < student.length; i++) {
            if (tenSinhVien.equals(student[i])) {
                student[i] = newInfor;
                break;
            }
        }
    }

    //hàm 4:
    public static void addNewStudent(String[] student) {
        String newStudent = inputOutput("Vui lòng nhập tên sinh viên mới: ");
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
