package Design_patterns.Interface;

public class logger
{
    Formatter obj;
    logger(Formatter obj)
    {
        this.obj = obj;
    }
    void print()
    {
        System.out.println(obj.format());
    }
}
