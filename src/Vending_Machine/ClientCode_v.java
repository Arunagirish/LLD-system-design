package Vending_Machine;

public class ClientCode_v
{
    public static void main(String[] args)
    {
        VendingMachine vendingMachine = VendingMachine.create_vendingmachine();
        Items item = vendingMachine.add_items("chips",3,20);

        vendingMachine.coin_inserted(Coin.FIVE);
        vendingMachine.select_product(item);
        int change = vendingMachine.dispatch();
    }
}
