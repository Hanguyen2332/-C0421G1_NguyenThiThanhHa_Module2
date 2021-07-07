package furamaResort.models;

import java.io.Serializable;

public class Contract implements Serializable {
   private String contractCode;
   private String bookingId;
   private double deposit;
   private double totalPayment;
   private String customerId;

    public Contract() {
    }

    public Contract(String contractCode, String bookingId, double deposit, double totalPayment, String customerId) {
        this.contractCode = contractCode;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractNumber) {
        this.contractCode = contractCode;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractCode + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
