package parking_lot;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ParkingStrategy
{
    Optional<ParkingSpot> find_spot(List<Floors> floors, vehicle vehicle);
}

class nearest implements ParkingStrategy
{
    @Override
    public Optional<ParkingSpot> find_spot(List<Floors> floors, vehicle vehicle)
    {
        for(Floors floor: floors)
        {
            for(String spot: floor.spotHashMap.keySet())
            {
                if(floor.spotHashMap.get(spot).is_available == true)
                {
                    return Optional.ofNullable(floor.spotHashMap.get(spot));
                }
            }
        }
        return Optional.empty();
    }
}