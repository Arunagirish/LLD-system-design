package Design_patterns.ChainOfResponsblity;

public abstract class LogHandler
{
    protected LogHandler logHandler;
    public abstract void log(int level);
    public void setNext(LogHandler logHandler)
    {
        this.logHandler = logHandler;
    }
}


class Consolehandler extends LogHandler
{
    @Override
    public void log(int level)
    {
        if(level<=1)System.out.println("console: log1");
        if(logHandler != null)
        {
            System.out.println("Its above console");
            logHandler.log(level);
        }
    }
}

class FileHandler extends LogHandler
{
    @Override
    public void log(int level)
    {
        if(level>2)System.out.println("log file: log2");
        if(logHandler != null)
        {
            System.out.println("Its above file");
            logHandler.log(level);
        }
    }
}