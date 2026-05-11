package parking_lot;

public class ParkingSpot
{
    int spot_id;
    vehicle vehicle;
    boolean is_available;
    VehicleSize size;
    ParkingSpot(int spot_id, VehicleSize size)
    {
        this.spot_id = spot_id;
        this.size = size;
        this.is_available = true;
    }
    void park(vehicle vehicle)
    {
        if(is_available == true && size == vehicle.size)
        {
            this.vehicle = vehicle;
            is_available = false;
        }
    }
}
