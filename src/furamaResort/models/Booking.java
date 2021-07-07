package furamaResort.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Booking implements Serializable {
    private String bookingId;
    private String startDay;
    private String endDay;
    private String customerId;
    private String serviceName;

    public Booking() {
    }

    public Booking(String bookingId, String startDay, String endDay, String customerId, String serviceName) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(customerId, booking.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId);
    }

    @Override
    public String toString() {
        return "{" +
                "bookingId='" + bookingId + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customerId='" + customerId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
