package furamaResort.services;


import furamaResort.libs.CheckProperty;
import furamaResort.libs.CheckValid;
import furamaResort.libs.QuickInOut;
import furamaResort.models.employee.AcademicLevel;
import furamaResort.models.employee.Employee;
import furamaResort.utils.ReadAndWrite;
import furamaResort.utils.ValidateInputData;

import java.io.File;
import java.util.*;

public class EmployeeServiceImpl extends CheckProperty implements EmployeeService {
    static Scanner sc = new Scanner(System.in);
    //field property
    String[] qualification = {"Trung cấp", "Cao đẳng", "Đại học", "Sau đại học"};
    String[] positions = {"Lễ tân", "phục vụ", "chuyên viên", "giám sát", "quản lý", "giám đốc"};
    //Tạo file
    static ReadAndWrite<Employee> employeeFile = new ReadAndWrite<>();
    static final String PATH_FILE = "D:\\module2\\src\\furamaResort\\data\\employee.csv";
    static File file = new File(PATH_FILE);
    //1. khởi tạo list Employee: rỗng
    static Collection<Employee> employeeList = new ArrayList<>();    //sửa: List<T> --> Collection<T>
    //2. khởi tạo giá trị list từ file:
    static {
        employeeList = employeeFile.readData(file);
    }

    public static Collection<Employee> readFileData() {  //cho chạy trc tiên --> khởi tạo dữ liệu,  //sửa: List<T> --> Collection<T>
        return employeeFile.readData(file);
    }

    @Override
    public void display() {  //ok
        // báo file rỗng: đã xử lý tại class ReadAndWrite: --> catch EOFEEx
        if (employeeList.isEmpty()) {
            System.err.println("List is empty!");
        }
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNew() {  // đã update: thêm mới vào file IO  -ok
        String id = QuickInOut.inputOutput("Enter employee.csv code : ");
        String name = QuickInOut.inputOutput("Enter employee.csv's full name: ");
        String dateOfBirth = ValidateInputData.dateOfBirth();
        String gender = QuickInOut.inputOutput("Enter gender: ");
        String idNumber = QuickInOut.inputOutput("Enter ID Number: ");
        String phone = QuickInOut.inputOutput("Enter phone number: ");
        String email = QuickInOut.inputOutput("Enter email: ");
        //nhap hoc van:
        System.out.println("Enter education: ");
        AcademicLevel newLevel = new AcademicLevel(checkInputProperty(qualification)); //mảng qualification: đã khai báo ở đầu class --> tái sử dụng ở hàm edit
        //nhap position:
        System.out.println("Enter position: ");
        String position = checkInputProperty(positions);
        //lương:
        System.out.println("Enter salary: ");
        double salary = CheckValid.checkFloatException(); //sửa: float --> double
        //add new:
        employeeList.add(new Employee(id, name, dateOfBirth, gender, idNumber, phone, email, newLevel, position, salary));
        employeeFile.writeData(PATH_FILE, employeeList);  //3. add new vào list--> ghi đè trở lại vào file --> update data
    }

    @Override
    public void edit() {   //ok - update: try/catch, cho loop --> nhập id + choice đến khi đúng
        boolean check = false;
        while (!check) {
            String employeeNumber = QuickInOut.inputOutput("Please enter employee.csv's ID : ");
            //lấy data từ file
            for (Employee employee : employeeList) {
                if (employeeNumber.equals(employee.getCode())) {
                    check = true;
                    employee.setFullName(QuickInOut.inputOutput("Enter new Name:"));
                    employee.setDateOfBirth(ValidateInputData.dateOfBirth());
                    employee.setGender(QuickInOut.inputOutput("Enter new gender:"));
                    employee.setIdNumber(QuickInOut.inputOutput("Enter new idNumber:"));
                    employee.setPhoneNumber(QuickInOut.inputOutput("Enter new phoneNumber:"));
                    employee.setEmail(QuickInOut.inputOutput("Enter new email:"));
                    AcademicLevel newLevel = new AcademicLevel(checkInputProperty(qualification));
                    employee.setAcademicLevel(newLevel);
                    String position = checkInputProperty(positions);
                    employee.setPosition(position);
                    System.out.println("Enter new salary:");
                    employee.setSalary(CheckValid.checkFloatException());
                    employeeFile.writeData(PATH_FILE, employeeList);
                }
            }
            if (!check) {
                System.err.println("NOT found this employee.csv-number! Please try again");
            }
        }
    }
}
//chỉnh sửa: cho extends class checkInputProperty  --> tái sử dụng code
//add - display(): UPDATE : Lưu list nhân viên = file IO: OK
//hàm edit():  ok . Update: try/catch, cho loop --> nhập id + chooise đến khi đúng
