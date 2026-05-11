package Design_patterns.Decorator;

public class extra_cheese implements burger_decorator
{
    burger obj;
    public extra_cheese(burger obj)
    {
        this.obj = obj;
    }
    @Override
    public int get_cost() 
    {
        return obj.get_cost()+10;
    }
}
