package Logger_System;

public abstract class Appender
{
    protected LogFormatter logFormatter;
    Appender next;
    public void setNext(Appender next)
    {
        this.next = next;
    }
    public void setLogFormatter(LogFormatter logFormatter)
    {
        this.logFormatter = logFormatter;
    }
    public abstract void append(LogMessage logMessage);
}

class ConsoleAppender extends Appender
{
    @Override
    public void append(LogMessage logMessage)
    {
        if(logMessage.getLogLevel().getValue() <= 2)
        {
            String formattedString = logFormatter.formatLog(logMessage);
            System.out.println("Console: " +formattedString);
        }
        if(next != null)
        {
            next.append(logMessage);
        }
    }
}

class FileAppender extends Appender
{
    @Override
    public void append(LogMessage logMessage)
    {
        String formattedString = logFormatter.formatLog(logMessage);
        System.out.println("File: " +formattedString);
    }
}
