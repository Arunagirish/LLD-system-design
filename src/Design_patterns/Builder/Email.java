package Design_patterns.Builder;

public class Email
{
    String to;
    String subject;
    String cc;
    private Email(Builder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.cc = builder.cc;
    }

    static class Builder {
        String to;
        String subject;
        String cc;

        Builder(String to, String subject) {
            this.to = to;
            this.subject = subject;
        }

        Builder cc(String cc) {
            this.cc = cc;
            return this;
        }

        Email build() {
            return new Email(this);
        }
    }
}


//Email email = new Email.Builder("abc@gmail.com", "Project Update")
//        .cc("manager@gmail.com")
//        .build(); because builder is static.