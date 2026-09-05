package parking_lot;

public class ParkingTicket
{
    ParkingSpot parkingSpot;
    vehicle vehicle;
    int ticketid;
    ParkingTicket(ParkingSpot parkingSpot, vehicle vehicle)
    {
        this.parkingSpot = parkingSpot;
        this.vehicle =vehicle;
        this.ticketid = 123;
    }

}
