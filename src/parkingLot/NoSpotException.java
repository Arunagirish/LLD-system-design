package parkingLot;

public class NoSpotException extends  RuntimeException
{
    NoSpotException(Vehicle vehicle)
    {
        System.out.println("No spot for vehicle"+vehicle.getCarNo());
    }
}
