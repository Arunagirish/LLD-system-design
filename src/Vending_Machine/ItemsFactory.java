package Vending_Machine;

public class ItemsFactory
{
    public static Items factoryItems(String item,int price,int quantity)
    {
        if(item == "chips") {
            System.out.println(quantity + "of" + item + "has been created for" + price + "rs");
            return new chips(item, price,quantity);
        }
        throw new IllegalArgumentException("Unknown type");
    }
}
