package BtAnhTrung;

import _04_class_object.excercise.Student;

import java.util.Scanner;

//Mục tiêu update: sử dụng static --> khai báo mảng student, chứa 50 phần tử là object của class Student
//      sử dụng static { } --> khởi tạo giá trị cho các phần tử của mảng

public class StudentManagement4 {
    static Scanner sc = new Scanner(System.in);
    public static Student[] student;

    static {
        student = new Student[50];
        student[0] = new Student(11, "Hà", 26, "Cẩm Lệ");
        student[1] = new Student(22, "Nhật", 24, "Sơn Trà");
        student[2] = new Student(33, "Phục", 21, "Hải Châu");
        student[3] = new Student(44, "Diệp", 30, "Điện Biên");
    }

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
                    displayStudentList(StudentManagement4.student);//Note: student giờ là biến STACTIC --> Nhớ truyền giá trị biến STACTIC này
                    break;                              //bằng cách: className.biến, nếu chỉ để "student" --> sẽ không in ra gì hết
                case 2:
                    //gọi hàm 2
                    deleteStudent(StudentManagement4.student);
                    break;
                case 3:
                    //gọi hàm 3
                    editStudentInfo(StudentManagement4.student);
                    break;
                case 4:
                    //gọi hàm 4
                    addNewStudent(StudentManagement4.student);
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
                System.out.println(element + "\t");
            }
        }
    }

    //hàm 2:
    public static void deleteStudent(Student[] student) {
        int idDeleteStudent = Integer.parseInt(inputOutput("Nhập ID sinh viên muốn xóa: "));
        for (int i = 0; i < student.length; i++) {
            if (idDeleteStudent == (student[i].getId())) {
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
                int id = Integer.parseInt(inputOutput("Vui lòng nhập ID mới: "));
                student[i].setId(id);
                //set Name:
                String name = inputOutput("Vui lòng nhập TÊN mới: ");
                student[i].setName(name);
                //set tuổi
                int age = Integer.parseInt(inputOutput("Vui lòng nhập TUỔI mới: "));
                student[i].setAge(age);
                //set địa chỉ
                String address = inputOutput("Vui lòng nhập  ĐỊA CHỈ mới: ");
                student[i].setAddress(address);
                break;
            }
        }
    }

    //hàm 4:
    public static void addNewStudent(Student[] student) {
        int id = Integer.parseInt(inputOutput("Vui lòng nhập ID sinh viên mới: "));
        String name = inputOutput("Vui lòng nhập TÊN sinh viên mới: ");
        int age = Integer.parseInt(inputOutput("Vui lòng nhập TUỔI sinh viên mới: "));
        String address = inputOutput("Vui lòng nhập  ĐỊA CHỈ sinh viên mới: ");
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

