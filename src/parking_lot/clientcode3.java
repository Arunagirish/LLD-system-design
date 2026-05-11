package parking_lot;

public class clientcode3
{
    public static void main(String[] args)
    {
        ParkingLotSingelton obj = ParkingLotSingelton.get_instance();
        Floors flr1 = new Floors(1);
        ParkingSpot parkingSpot = new ParkingSpot(123,VehicleSize.small);
        vehicle bike = new vehicle("Tn 38",VehicleSize.small);
        parkingSpot.park(bike);
        flr1.add_spot(parkingSpot);
        obj.add_floors(flr1);
    }
}
