package furamaResort.models;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String serviceCode;
    private double useArea;
    private double rentalFees;
    private int maxNumsPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, double useArea, double rentalFees, int maxNumsPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.useArea = useArea;
        this.rentalFees = rentalFees;
        this.maxNumsPeople = maxNumsPeople;
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentalFees() {
        return rentalFees;
    }

    public void setRentalFees(double rentalFees) {
        this.rentalFees = rentalFees;
    }

    public int getMaxNumsPeople() {
        return maxNumsPeople;
    }

    public void setMaxNumsPeople(int maxNumsPeople) {
        this.maxNumsPeople = maxNumsPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "utilName='" + serviceCode + '\'' +
                ", useArea=" + useArea +
                ", rentalFees=" + rentalFees +
                ", maxNumsPeople=" + maxNumsPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
