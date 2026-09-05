package Design_patterns.State;

public abstract class VendingMachineState
{
    ClientCode clientCode;

    protected abstract void Idle();
    protected abstract void coinInserted();
    protected abstract void productSelect();
    protected abstract void dispense();
}

class IdleState extends  VendingMachineState
{

    @Override
    protected void Idle() {
        System.out.println("its in idle state");
        clientCode.setState(new CoinInsertedState());
    }

    @Override
    protected void coinInserted() {

    }

    @Override
    protected void productSelect() {

    }

    @Override
    protected void dispense() {

    }
}

class CoinInsertedState extends  VendingMachineState
{

    @Override
    protected void Idle() {
    }

    @Override
    protected void coinInserted()
    {
        System.out.println("its in Coin InsertedState");
        clientCode.setState(new IdleState());
    }

    @Override
    protected void productSelect() {

    }

    @Override
    protected void dispense() {

    }
}



