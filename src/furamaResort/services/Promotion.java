package furamaResort.services;

import furamaResort.models.Booking;

import java.util.Stack;

public interface Promotion extends Service {
    void displayCustomerGetVoucher();

    int[] setVoucherNumbers();

    Stack<Booking> getThisMonthBooking();
}
