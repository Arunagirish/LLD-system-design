package parkingLot;

import java.util.List;

public class ParkingLotManager
{
    private static volatile ParkingLotManager parkingLotManager;
    private ParkingLotManager(){};
    private List<Floors> floors;
    private FindSpotStrategy findSpotStrategy;
    public static ParkingLotManager get_instance()
    {
        if(parkingLotManager == null)
        {
            synchronized (ParkingLotManager.class)
            {
                if(parkingLotManager == null)
                {
                    parkingLotManager = new ParkingLotManager();
                }
            }
        }
        return parkingLotManager;
    }

    public void park(Floors floor,Vehicle vehicle)
    {
        floor.removeSpot(vehicle.getSize(),1);
        vehicle.setFloors(floor);
    }

    public void unpark(Vehicle vehicle)
    {
        Floors floor = vehicle.getFloor();
        floor.addSpots(vehicle.getSize(),1);
    }

//    depedency injection for Finding spot
    public void setFindSpotStrategy(FindSpotStrategy findSpotStrategy)
    {
        this.findSpotStrategy = findSpotStrategy;
    }

//    getter and setter for floors
    public List<Floors> getFloors() {
        return floors;
    }
    public void addFloors(Floors floor)
    {
        floors.add(floor);
    }
}
