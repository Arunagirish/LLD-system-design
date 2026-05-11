package Design_patterns.strategy;

public class TextEditor
{
    private TextFormatter obj;
    public TextEditor(TextFormatter obj)
    {
        this.obj = obj;
    }
    public void print(String str)
    {
        obj.format(str);
    }
}
