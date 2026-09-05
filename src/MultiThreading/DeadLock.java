package MultiThreading;

class DeadLock1
{
    Object lock = new Object();
    Object lock2 = new Object();

    Thread t1 = new Thread(()->
    {
        synchronized (lock)
        {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2)
            {
                System.out.println("hello");
            }
        }
    });

    Thread t2 = new Thread(()->
    {
        synchronized (lock2)
        {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock)
            {
                System.out.println("hello");
            }
        }
    });

    public void call()
    {
        t1.start();
        t2.start();
    }
}

public class DeadLock
{
    public static void main(String[] args)
    {
        DeadLock1 obj = new DeadLock1();
        obj.call();
    }
}
