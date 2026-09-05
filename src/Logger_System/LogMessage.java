package Logger_System;

public class LogMessage
{
    private final LogLevel level;
    final String   message;
    private final String   className;
    private final long     timestamp;
    private final String   threadName;

    private LogMessage(Builder builder)
    {
        this.level      = builder.level;
        this.message    = builder.message;
        this.className  = builder.className;
        this.timestamp  = builder.timestamp;
        this.threadName = builder.threadName;
    }

    public LogLevel getLogLevel()
    {
        return this.level;
    }

    public static class Builder
    {
        private LogLevel level;
        private String   message;
        private String   className;
        private long     timestamp  = System.currentTimeMillis();
        private String   threadName = Thread.currentThread().getName();

        public Builder level(LogLevel level) {
            this.level = level;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder className(String className) {
            this.className = className;
            return this;
        }

        public LogMessage build() {
            return new LogMessage(this);
        }
    }
}
