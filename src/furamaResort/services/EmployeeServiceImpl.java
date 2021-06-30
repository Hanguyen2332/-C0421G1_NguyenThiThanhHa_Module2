package furamaResort.services;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import furamaResort.models.employee.AcademicLevel;
import furamaResort.models.employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner sc = new Scanner(System.in);
    String[] qualification = {"Trung cấp", "Cao đẳng", "Đại học", "Sau đại học"};
    String[] positions = {"Lễ tân", "phục vụ", "chuyên viên", "giám sát", "quản lý", "giám đốc"};

    static List<Employee> employees = new ArrayList<>();  // khởi tạo list nhân viên

    static {
        employees.add(new Employee("FRM111", "Đồng Văn Nhật", "2/3/1997", "nữ", "11223344",
                "0949123145", "nhatvd@gmail.com", new AcademicLevel("Đại học"), "chuyên viên", 10));
        employees.add(new Employee("FRM222", "Đồng Văn Tài", "12/3/1995", "nữ", "12345567",
                "0393533666", "taivd@gmail.com", new AcademicLevel("Cao đẳng"), "quản lý", 13));
        employees.add(new Employee("FRM333", "Đồng Văn Phục", "12/3/2002", "phi giới tính", "3993572",
                "0310666777", "phucvd@gmail.com", new AcademicLevel("Trung cấp"), "phục vụ", 8));
    }

    @Override
    public void display() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNew() {
        String id = inputOutput("Enter employee code : ");
        String name = inputOutput("Enter employee's full name: ");
        String dateOfBirth = inputOutput("Enter date Of Birth: ");
        String gender = inputOutput("Enter gender: ");
        String idNumber = inputOutput("Enter ID Number: ");
        String phone = inputOutput("Enter phone number: ");
        String email = inputOutput("Enter email: ");
        //nhap hoc van:
        System.out.println("Enter education: ");
        AcademicLevel newLevel = new AcademicLevel(checkInputProperty(qualification)); //mảng qualification: đã khai báo ở đầu class --> tái sử dụng ở hàm edit
        //nhap position:
        System.out.println("Enter position: ");
        String position = checkInputProperty(positions);
        //lương:
        float salary = Float.parseFloat(inputOutput("Enter salary: "));
        //add new:
        employees.add(new Employee(id, name, dateOfBirth, gender, idNumber, phone, email, newLevel, position, salary));
    }

    @Override
    public void edit() {
        boolean check = false;
        String employeeNumber = inputOutput("Please enter ID: ");
        for (Employee employee : employees) {
            if (employeeNumber.equals(employee.getCode())) {
                check = true;
                boolean runLoop = true;  // biến runloop: đk chạy - dừng vòng lặp
                do {
                    System.out.println("Property list: \n 1. FullName\n 2. dateOfBirth\n 3. gender\n 4. idNumber\n 5. phoneNumber\n " +
                            "6. email\n 7. qualification \n 8. position\n 9. salary\n  0. Exit\n" +
                            "Please select the item you want to edit: ");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            employee.setFullName(inputOutput("Enter new Name:"));
                            break;
                        case 2:
                            employee.setDateOfBirth(inputOutput("Enter new Name:"));
                            break;
                        case 3:
                            employee.setGender(inputOutput("Enter new gender:"));
                            break;
                        case 4:
                            employee.setIdNumber(inputOutput("Enter new idNumber:"));
                            break;
                        case 5:
                            employee.setPhoneNumber(inputOutput("Enter new phoneNumber:"));
                            break;
                        case 6:
                            employee.setEmail(inputOutput("Enter new email:"));
                            break;
                        case 7:
                            AcademicLevel newLevel = new AcademicLevel(checkInputProperty(qualification));
                           employee.setAcademicLevel(newLevel);
                            break;
                        case 8:
                            String position = checkInputProperty(positions);
                            employee.setPosition(position);
                            break;
                        case 9:
                            employee.setSalary(Float.parseFloat(inputOutput("Enter new salary:")));
                            break;
                        case 0:
                            runLoop = false;  //ĐK dừng loop
                            break;
                        default:
                            System.err.println("your enter is mismatch. please try again.");
                    }
                } while (runLoop);
            }
        }
        if (!check) {
            System.err.println("NOT found this employee-number!");
        }
    }

    @Override
    public String checkInputProperty(String[] arr) {
        System.out.println("There are " + arr.length + " options: " + Arrays.toString(arr));
        String input;
        boolean check = false;
        do {
            input = inputOutput("Enter one of them: ");
            for (String e : arr) {
                if ((input.toUpperCase().equals(e.toUpperCase()))) {
                    input = e;
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.err.println("your enter is NOT match! please try again! ");
            }
        } while (!check);
        return input;
    }

    public static String inputOutput(String massage) {
        System.out.println(massage);
        return sc.nextLine();
    }
}


