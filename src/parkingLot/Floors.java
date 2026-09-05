package parkingLot;

import java.util.HashMap;
import java.util.Map;

public class Floors
{
    private Map<VehicleSize,Integer> spot = new HashMap<>();
    public void addSpots(VehicleSize vehicleSize, Integer availablity)
    {
        spot.put(vehicleSize,spot.getOrDefault(vehicleSize,0)+availablity);
    }

    public void removeSpot(VehicleSize vehicleSize, Integer availablity)
    {
        if(spot.containsKey(vehicleSize))
        {
            if(spot.get(vehicleSize) > availablity){
                spot.put(vehicleSize,spot.getOrDefault(vehicleSize,0)-availablity);
            }
            else {
                spot.remove(vehicleSize);
            }
        }
    }

    public Map<VehicleSize,Integer> getSpot()
    {
        return spot;
    }

}
