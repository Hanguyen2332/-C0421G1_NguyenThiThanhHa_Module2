package furamaResort.models;

public class House extends Facility {
    private String roomStandard;
    private int floors;

    public House() {
    }

    public House(String roomStandard, int floors) {
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public House(String utilName, float useArea, float rentalFees, int maxNumsPeople, String rentalType, String roomStandard, int floors) {
        super(utilName, useArea, rentalFees, maxNumsPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                "roomStandard='" + roomStandard + '\'' +
                ", floors=" + floors +
                '}';
    }
}
