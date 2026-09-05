package Elevator_System;

import java.util.List;

public interface ElevatorStrategy
{
    Elevators availableElevator(List<Elevators> elevatorsList, Request request);
}

class NearestElevatorStrategy implements ElevatorStrategy
{
    @Override
    public Elevators availableElevator(List<Elevators> elevatorsList, Request request) {
        Elevators best = null;
        int minDist = Integer.MAX_VALUE;

        for(Elevators elevators: elevatorsList)
        {
            if(elevators.elevatorState.getDirection() == Direction.IDLE)
            {
                int dist = Math.abs(request.sourceFloor - elevators.currentFloor);
                if(dist < minDist)
                {
                    minDist = dist;
                    best = elevators;
                }
            }
            else
            {
                int dist = Math.abs(request.sourceFloor - elevators.currentFloor);
                if(request.direction == elevators.elevatorState.getDirection() && dist < minDist)
                {
                    minDist = dist;
                    best = elevators;
                }
            }
        }
        return best;
    }
}

