package furamaResort.models;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String serviceCode;
    private float useArea;
    private double rentalFees;
    private int maxNumsPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, float useArea, double rentalFees, int maxNumsPeople, String rentalType) {
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

    public float getUseArea() {
        return useArea;
    }

    public void setUseArea(float useArea) {
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
