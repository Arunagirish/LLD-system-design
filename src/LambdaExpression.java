public class LambdaExpression
{
    public static void main(String[] args)
    {
        Lambda lambda = ()->{System.out.println("hello");};

//        what it internally does
//        Lambda lambda = new Lambda() {
//            @Override
//            public void call() {
//                System.out.println("hello");
//            }
//        };
    }
}

@FunctionalInterface
interface Lambda
{
    public abstract void call();
}
