package Vending_Machine;

public abstract class Items
{
    String itemName;
    int price;
    int quantity;
    Items(String itemName, int price, int quantity)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

class chips extends Items
{
    chips(String itemName, int price, int quantity) {
        super(itemName, price,quantity);
    }
}
