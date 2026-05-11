package Design_patterns.Interface;

public class JsonFormatter implements Formatter
{
    public String format()
    {
        return "{\"log\": \"Server started on port 8080\"}";
    }
}

