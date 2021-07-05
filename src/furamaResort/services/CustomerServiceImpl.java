package furamaResort.services;

import furamaResort.libs.CheckProperty;
import furamaResort.libs.QuickInOut;
import furamaResort.models.Customer;

import furamaResort.utils.ReadAndWrite;
import furamaResort.utils.ValidateInputData;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner sc = new Scanner(System.in);
    private String[] customerType = {"Diamond", "Platinum", "Gold", "Silver", "Member"}; //tại sao biến mảng: không cần static--> vẫn gọi đc trong hàm?
    //file
    public static ReadAndWrite<Customer> customerFile = new ReadAndWrite<>();
    private static final String PATH_CUSTOMER = "D:\\module2\\src\\furamaResort\\data\\customer";
    private static File file = new File(PATH_CUSTOMER);
    //list:
    private static Collection<Customer> customerList = new LinkedList<>();  //sửa: List<T> --> Collection<T>
     static {
        customerList = customerFile.readData(file);
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNew() {  //ok
        String customerCode = QuickInOut.inputOutput("Enter employee code : ");
        String name = QuickInOut.inputOutput("Enter employee's full name: ");
        String dateOfBirth = ValidateInputData.dateOfBirth();
        String gender = QuickInOut.inputOutput("Enter gender: ");
        String idNumber = QuickInOut.inputOutput("Enter ID Number: ");
        String phone = QuickInOut.inputOutput("Enter phone number: ");
        String email = QuickInOut.inputOutput("Enter email: ");
        //nhap customer-type:
        System.out.println("Enter customer-type: ");
        String type = CheckProperty.checkInputProperty(customerType); //mảng qualification: đã khai báo ở đầu class --> tái sử dụng ở hàm edit
        //address:
        String address = QuickInOut.inputOutput("Enter address: ");
        //thêm object vào List:
        customerList.add(new Customer(customerCode, name, dateOfBirth, gender, idNumber, phone, email, type, address));
        customerFile.writeData(PATH_CUSTOMER, customerList);

    }

    @Override
    public void edit() {
        boolean check = false;
        while (!check) {
            String customerCode = QuickInOut.inputOutput("Please enter customer-code: ");
            for (Customer customer : customerList) {
                if (customerCode.equals(customer.getCode())) {
                    check = true;
                    customer.setFullName(QuickInOut.inputOutput("Enter new Name:"));
                    customer.setDateOfBirth(ValidateInputData.dateOfBirth());
                    customer.setGender(QuickInOut.inputOutput("Enter new gender:"));
                    customer.setIdNumber(QuickInOut.inputOutput("Enter new idNumber:"));
                    customer.setPhoneNumber(QuickInOut.inputOutput("Enter new phoneNumber:"));
                    customer.setEmail(QuickInOut.inputOutput("Enter new email:"));
                    String type = CheckProperty.checkInputProperty(customerType);
                    customer.setCustomerType(type);
                    customer.setAddress(QuickInOut.inputOutput("Enter new address: "));
                    customerFile.writeData(PATH_CUSTOMER, customerList);
                }
            }
            if (!check) {
                System.err.println("NOT found this employee-number! Please try again");
            }
        }
    }
    public static Collection<Customer> getCustomerList(){
         return customerList;
    }
}
// 5/7: sửa tên link file customer: PATH_FILE --> PATH_CUSTOMER