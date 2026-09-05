package Elevator_System;

public abstract class ElevatorState
{
    ElevatorState elevatorState;
    public void transitionTO(ElevatorState elevatorState)
    {
        this.elevatorState = elevatorState;
    }
    protected abstract void addRequest(Elevators elevators, Request request);
    protected abstract Direction getDirection();
    protected abstract void move(Elevators elevators);
}

class IdleState extends ElevatorState
{
    @Override
    protected void addRequest(Elevators elevators, Request request)
    {
        elevators.addQueue(request);
        if(request.direction == Direction.UP)
        {
            transitionTO(new GoingUpState());
        }
        else transitionTO(new GoingDownState());
    }

    @Override
    protected Direction getDirection() {
        return  Direction.IDLE;
    }

    @Override
    protected void move(Elevators elevators)
    {
        System.out.println(elevators.id + ": elevator is not moving");
    }
}

class GoingUpState extends ElevatorState
{
    @Override
    protected void addRequest(Elevators elevators, Request request)
    {
        elevators.addQueue(request);
        if(request.direction == Direction.IDLE)
        {
            transitionTO(new IdleState());
        }
        else transitionTO(new GoingDownState());
    }

    @Override
    protected Direction getDirection() {
        return  Direction.UP;
    }

    @Override
    protected void move(Elevators elevators) {

    }
}

class GoingDownState extends ElevatorState
{
    @Override
    protected void addRequest(Elevators elevators, Request request)
    {
        elevators.addQueue(request);
        if(request.direction == Direction.IDLE)
        {
            transitionTO(new IdleState());
        }
        else transitionTO(new GoingUpState());
    }

    @Override
    protected Direction getDirection() {
        return  Direction.DOWN;
    }

    @Override
    protected void move(Elevators elevators) {

    }
}
