package Design_patterns.ChainOfResponsblity;

public class ClientCode
{
    public static void main(String[] args)
    {
        LogHandler consolehandler = new Consolehandler();
        LogHandler filehandler = new FileHandler();
        consolehandler.setNext(filehandler);

        consolehandler.log(4);
    }
}
