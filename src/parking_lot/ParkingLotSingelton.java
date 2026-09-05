package parking_lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ParkingLotSingelton
{
    private static ParkingLotSingelton obj;
//    immutable should not be changed
    private final List<Floors> floors = new ArrayList<>();
    private final HashMap<String,Tickets> tickets = new HashMap<>();
    private ParkingStrategy parkingStrategy;
    private FeeStrategy feeStrategy;


    public static ParkingLotSingelton get_instance()
    {
        if(obj == null)
        {
            obj = new ParkingLotSingelton();
            return obj;
        }
        return obj;
    }

    public void add_floors(Floors floors)
    {
        this.floors.add(floors);
    }

    public void inject_parking_strategy(ParkingStrategy parkingStrategy)
    {
        this.parkingStrategy = parkingStrategy;
    }

    public void park_vehicle(vehicle vehicle)
    {
        Optional<ParkingSpot> parkingSpot = parkingStrategy.find_spot( floors,  vehicle);
        if(parkingSpot.isPresent())
        {
            ParkingSpot spot = parkingSpot.get();
            spot.park(vehicle);
            ParkingTicket ticket = new ParkingTicket(spot,vehicle);
        }
    }


}
