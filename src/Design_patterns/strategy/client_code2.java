package Design_patterns.strategy;

public class client_code2
{
    public static  void  main(String[] args)
    {
        TextEditor obj = new TextEditor(new LowerCaseFormatter());
        obj.print("hdello");
    }
}
