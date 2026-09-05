package Vending_Machine;

abstract class  VendingMachineState
{
    VendingMachine vendingMachine;
    VendingMachineState(VendingMachine vendingMachine)
    {
        this.vendingMachine  = vendingMachine;
    }
    abstract void coin_inserted(Coin coin);
    abstract void select_product(Items item);
    abstract int dispatch();
}

class IdleState extends VendingMachineState {

    IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void coin_inserted(Coin coin) {
        vendingMachine.cashManager.add_coin(coin);
        System.out.println("coin inserted");
        vendingMachine.set_state(new CoinInsertedState(vendingMachine));
    }

    @Override
    public void select_product(Items item) {
        System.out.println("no product selected");
    }

    @Override
    public int dispatch() {
        System.out.println("no product to be dispatched");
        return 0;
    }
}

class CoinInsertedState extends VendingMachineState {

    CoinInsertedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void coin_inserted(Coin coin) {
        vendingMachine.cashManager.add_coin(coin);
        System.out.println("coin inserted again");
    }

    @Override
    public void select_product(Items item)
    {


    }

    @Override
    public int dispatch() {
        return 0;
    }
}

class DispatchState extends VendingMachineState {

    DispatchState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void coin_inserted(Coin coin) {

    }

    @Override
    public void select_product(Items item) {

    }

    @Override
    public int dispatch() {
        return 0;
    }
}


