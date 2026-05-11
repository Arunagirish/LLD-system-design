public class Email
{
    private final String to;
    private final String from;
    private String body;

    private Email(builder obj)
    {
        this.to = obj.to;
        this.from = obj.from;
        this.body = obj.body;
    }

//    public void body_setter(String body)
//    {
//        this.body = body;
//    }

    static class builder
    {
        private String to;
        private String from;
        private String body;

        builder to_builder(String to)
        {
            this.to = to;
            return this;
        }

        builder from_builder(String from)
        {
            this.from = from;
            return this;
        }

        Email final_build()
        {
            return new Email(this);
        }

    }

}
