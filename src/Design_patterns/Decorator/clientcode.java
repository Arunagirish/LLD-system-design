package Design_patterns.Decorator;

public class clientcode
{
    public static void main(String args[])
    {
        burger obj = new zinger_burger();
        System.out.println(obj.get_cost());
        burger_decorator obj1 = new extra_cheese(obj);
        System.out.println(obj1.get_cost());

    }
}
