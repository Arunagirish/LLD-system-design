package MultiThreading;

public class BlockedState
{
    public static void main(String[] args)
    {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 acquired lock");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1 releasing lock");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 acquired lock");
            }
        });

        t1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        t2.start();
    }
}


