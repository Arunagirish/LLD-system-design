package Design_patterns.strategy;

public interface TextFormatter
{
    void format(String text);
}

class UpperCaseFormatter implements TextFormatter
{
    @Override
    public void format(String text) {
        System.out.println("HELLO");
    }
}

class LowerCaseFormatter implements TextFormatter
{
    @Override
    public void format(String text) {
        System.out.println("hello");
    }
}

class TitleCaseFormatter implements TextFormatter
{
    @Override
    public void format(String text) {
        System.out.println("Hello");
    }
}