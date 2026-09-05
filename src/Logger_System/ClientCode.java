package Logger_System;

import Design_patterns.Interface.JsonFormatter;

public class ClientCode
{
    public static void main(String[] args)
    {
        Logger logger = Logger.get_instance("PersistanceClass");
        ConsoleAppender consoleAppender = new ConsoleAppender();
        FileAppender fileAppender = new FileAppender();

        consoleAppender.next = fileAppender;
        consoleAppender.setLogFormatter(new JsonText());

        fileAppender.setLogFormatter(new PlainText());

//        chain of responsblity so only call once
        logger.addAppender(consoleAppender);

        logger.trace("Runtime error");
        logger.info("Order placed");
    }
}
