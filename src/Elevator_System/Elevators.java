package Elevator_System;

import java.util.Queue;

public class Elevators
{
    int currentFloor;
    String id;
    ElevatorState elevatorState;
    Queue<Request> requestQueue;

    public void addQueue(Request request)
    {
        requestQueue.add(request);
    }

}
