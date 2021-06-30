package _17_binary_file.practice.th2;

import java.util.ArrayList;
import java.util.List;

import static _17_binary_file.practice.th2.ReadAndWrite.writeToFile;

public class Run {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Lê Văn Quyết", "Quảng Nam"));
        students.add(new Student(2, "Nguyễn Thị Hạnh", "Quảng Trị"));
        students.add(new Student(3, "Lê Thị Mỹ Linh", "Đà Nẵng"));
        students.add(new Student(4, "Phạm Nhật Vượng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Phục", "Huế"));
        writeToFile("D:\\module2\\src\\_17_binary_file\\practice\\th2\\student", students);
        List<Student> studentDataFromFile = ReadAndWrite.readDataFromFile("student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
