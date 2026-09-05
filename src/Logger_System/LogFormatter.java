package Logger_System;

public interface LogFormatter
{
    String formatLog(LogMessage logMessage);
}

class JsonText implements LogFormatter
{
    @Override
    public String formatLog(LogMessage logMessage)
    {
        String formatted = "json: "+"{"+logMessage.message+"}";
        return formatted;
    }
}

class PlainText implements LogFormatter
{
    @Override
    public String formatLog(LogMessage logMessage)
    {
        String formatted = "Plain text: "+logMessage.message;
        return formatted;
    }
}