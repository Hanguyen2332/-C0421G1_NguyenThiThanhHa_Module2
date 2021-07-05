package furamaResort.models;

public class Room extends Facility {
    private String freeServices; //Quầy bar/Cafe/Dịch vụ Spa/Dịch vụ phòng họp/Dịch vụ giặt, ủi/Dịch vụ phòng 24/24/
    // Dịch vụ xe đưa đón sân bay/Sân golf và sân tennis/Fitness centre/Dịch vụ bể bơi 4 mùa/Thu đổi ngoại tệ....

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String serviceCode, float useArea, double rentalFees, int maxNumsPeople, String rentalType, String freeServices) {
        super(serviceCode, useArea, rentalFees, maxNumsPeople, rentalType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices='" + freeServices + '\'' + super.toString() +
                '}';
    }
}
