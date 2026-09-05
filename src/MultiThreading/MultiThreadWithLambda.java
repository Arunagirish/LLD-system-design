package MultiThreading;

public class MultiThreadWithLambda
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(()->{System.out.println("Thread creation");});
//        anonymous inner class
//        Consider like this:
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread creation");
//            }
//        });

        Runnable runnable = ()->{System.out.println("Thread creation");};

//        Consider like this:
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread creation");
//            }
//        };
    }
}
