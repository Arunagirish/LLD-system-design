package Logger_System;

import Design_patterns.Interface.logger;
import java.lang.invoke.VolatileCallSite;
import java.util.ArrayList;
import java.util.List;

public class Logger
{
    private static volatile  Logger logger;
    List<Appender> appenderList = new ArrayList<>();
    String className;
    private Logger(String className)
    {
        this.className = className;
    }
    public static Logger get_instance(String className)
    {
        if(logger == null)
        {
            synchronized (Logger.class)
            {
                if(logger == null)
                {
                    logger = new Logger(className);
                }
            }
        }
        return logger;
    }

    private void log(LogLevel level, String message)
    {
        LogMessage logMessage = new LogMessage.Builder()
                .level(level)
                .message(message)
                .className(className)
                .build();
        if (!appenderList.isEmpty()) {
            appenderList.get(0).append(logMessage);
        }

//        for (Appender appender : appenderList) {
//            appender.append(logMessage);
//        }
    }

    public void addAppender(Appender appender)
    {
        appenderList.add(appender);
    }

    public void trace(String message) { log(LogLevel.TRACE, message); }
    public void debug(String message) { log(LogLevel.DEBUG, message); }
    public void info(String message)  { log(LogLevel.INFO,  message); }
    public void warn(String message)  { log(LogLevel.WARN,  message); }
    public void error(String message) { log(LogLevel.ERROR, message); }
    public void fatal(String message) { log(LogLevel.FATAL, message); }

}
