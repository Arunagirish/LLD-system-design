package parkingLot;

import java.util.List;

public interface FindSpotStrategy
{
    public Floors findSlot(List<Floors> floors, Vehicle vehicle);
}

class EarliestFloor implements FindSpotStrategy
{
    @Override
    public Floors findSlot(List<Floors> floors, Vehicle vehicle) {
        VehicleSize vehicleSize = vehicle.getSize();
        for(Floors floor: floors)
        {
            if(floor.getSpot().containsKey(vehicleSize))
            {
                return floor;
            }
            else
            {
                throw  new NoSpotException(vehicle);
            }
        }
        return null;
    }

}
