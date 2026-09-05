package Vending_Machine;

import java.util.List;

public class VendingMachine
{
    private static VendingMachine vendingMachine;
    CashManager cashManager;
    List<Items> items_list;
    VendingMachineState vendingMachineState;
    private VendingMachine()
    {
        System.out.println("vending machine created successfully");
    }
    public Items add_items(String item,int price,int quantity)
    {
        Items item_obj = ItemsFactory.factoryItems(item,price,quantity);
        items_list.add(item_obj);
        return item_obj;
    }
    public static VendingMachine create_vendingmachine()
    {
        if(vendingMachine == null)
        {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }
    public void coin_inserted(Coin coin)
    {
        vendingMachineState.coin_inserted(coin);
    }
    public void select_product(Items items)
    {
        vendingMachineState.select_product(items);
    }
    public int dispatch()
    {
        return vendingMachineState.dispatch();
    }
    public void set_state(VendingMachineState vendingMachineState)
    {
        this.vendingMachineState = vendingMachineState;
    }
}
