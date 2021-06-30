package furamaResort.services;

import furamaResort.models.Customer;
import furamaResort.models.employee.AcademicLevel;
import furamaResort.models.employee.Employee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner sc = new Scanner(System.in);
    private String[] customerType = {"Diamond", "Platinum", "Gold", "Silver", "Member"}; //tại sao biến mảng: không cần static--> vẫn gọi đc trong hàm?
    private static List<Customer> customers = new LinkedList<>();

    static {
        customers.add(new Customer("CTM111", "Kim Jung Kook", "2/3/1997", "Nam", "1456",
                "0909222333", "Kooking@outlook.com", "Platinum", "Hàn Quốc"));
        customers.add(new Customer("CTM222", "Lê Thị Sen", "7/8/1995", "Nữ", "13684",
                "0236154333", "senle@gmail.com", "Member", "Việt Nam"));
        customers.add(new Customer("CTM333", "Lý Tiến Trình", "3/5/1974", "Nam", "09604",
                "0635222147", "trinhlt@outlook.com", "Gold", "Trung Quốc"));
    }

    @Override
    public void display() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }

    }

    @Override
    public void addNew() {
        String customerCode = inputOutput("Enter employee code : ");
        String name = inputOutput("Enter employee's full name: ");
        String dateOfBirth = inputOutput("Enter date Of Birth: ");
        String gender = inputOutput("Enter gender: ");
        String idNumber = inputOutput("Enter ID Number: ");
        String phone = inputOutput("Enter phone number: ");
        String email = inputOutput("Enter email: ");
        //nhap customer-type:
        System.out.println("Enter customer-type: ");
        String type = checkInputProperty(customerType); //mảng qualification: đã khai báo ở đầu class --> tái sử dụng ở hàm edit
        //address:
        String address = inputOutput("Enter address: ");
        //thêm object vào List:
        customers.add(new Customer(customerCode,name,dateOfBirth,gender,idNumber,phone,email,type,address));
    }

    @Override
    public void edit() {
        boolean check = false;
        String customerCode = inputOutput("Please enter customer-code: ");
        for (Customer customer : customers) {
            if (customerCode.equals(customer.getCode())) {
                check = true;
                boolean runLoop = true;  // biến runloop: đk chạy - dừng vòng lặp
                do {
                    System.out.println("Property list: \n 1. FullName\n 2. dateOfBirth\n 3. gender\n 4. idNumber\n 5. phoneNumber\n " +
                            "6. email\n 7. Customer-type \n 8. address\n 0. Exit\n" +
                            "Please select the item you want to edit: ");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            customer.setFullName(inputOutput("Enter new Name:"));
                            break;
                        case 2:
                            customer.setDateOfBirth(inputOutput("Enter new Name:"));
                            break;
                        case 3:
                            customer.setGender(inputOutput("Enter new gender:"));
                            break;
                        case 4:
                            customer.setIdNumber(inputOutput("Enter new idNumber:"));
                            break;
                        case 5:
                            customer.setPhoneNumber(inputOutput("Enter new phoneNumber:"));
                            break;
                        case 6:
                            customer.setEmail(inputOutput("Enter new email:"));
                            break;
                        case 7:
                            String type = checkInputProperty(customerType);
                            customer.setCustomerType(type);
                            break;
                        case 8:
                            customer.setAddress(inputOutput("Enter new address: "));
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
            System.err.println("NOT found this customer-number!");
        }
    }

    @Override
    public String checkInputProperty(String[] arr) {  //suy nghĩ: có thể tạo class "CheckInputProperty" trong package "Libs" --> tạo method dùng chung cho các class ??
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
