package parkingLot;

public class Vehicle {
    private final String carNo;
    private final VehicleSize vehicleSize;
    boolean payed;
    Floors floors;

    Vehicle(String carNo, VehicleSize vehicleSize)
    {
        this.carNo = carNo;
        this.vehicleSize = vehicleSize;
    }

    public VehicleSize getSize()
    {
        return vehicleSize;
    }

    public String getCarNo()
    {
        return carNo;
    }
    public void setFloors(Floors floors)
    {
        this.floors = floors;
    }

    public Floors getFloor()
    {
        return floors;
    }
}
