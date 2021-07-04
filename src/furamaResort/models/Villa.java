package furamaResort.models;

import java.io.Serializable;

public class Villa extends Facility {
    private String standard;  // đơn lập, song lập, liền kề ?
    private float poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String standard, float poolArea, int floors) {
        this.standard = standard;// tiêu chuẩn phòng
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(String serviceCode, float useArea, double rentalFees, int maxNumsPeople, String rentalType, String standard, float poolArea, int floors) {
        super(serviceCode, useArea, rentalFees, maxNumsPeople, rentalType);
        this.standard = standard;
        this.poolArea = poolArea;
        this.floors = floors;
    }


    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + standard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }
}
