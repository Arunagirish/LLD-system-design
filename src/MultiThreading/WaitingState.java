package MultiThreading;

public class WaitingState {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 acquired lock");

                try {
                    System.out.println(Thread.currentThread().getName() + " lock released");
                    lock.wait(); // releases monitor and goes to WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1 resumed");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 acquired lock");
                System.out.println("T2 notifying...");
                lock.notify(); // wakes one waiting thread
            }
        });

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        t2.start();
    }
}
