package parking_lot;
import java.util.Map;

public class Floors
{
    int floors;
    Map<String,ParkingSpot> spotHashMap;
    void add_spot(ParkingSpot spot)
    {
        spotHashMap.put("123",spot);
    }
    Floors(int floor_no)
    {
        floors = floor_no;
    }

}

