package furamaResort.models;

import java.util.Date;

public class Customer extends Person {
    private String customerType; // (Diamond, Platinum , Gold, Silver, Member)???.
    private String address;

    public Customer() {
    }

    public Customer(String customerType, String address) {
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String code, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String customerType, String address) {
        super(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}' + super.toString();
    }
}
