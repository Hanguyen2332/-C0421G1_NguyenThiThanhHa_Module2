package furamaResort.models;

public class House extends Facility {
    private String standard;
    private int floors;

    public House() {
    }

    public House(String standard, int floors) {
        this.standard = standard;
        this.floors = floors;
    }

    public House(String serviceCode, float useArea, double rentalFees, int maxNumsPeople, String rentalType, String standard, int floors) {
        super(serviceCode, useArea, rentalFees, maxNumsPeople, rentalType);
        this.standard = standard;
        this.floors = floors;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + standard + '\'' +
                ", floors= " + floors + super.toString() +
                '}';
    }
}
