package MultiThreading;

import java.util.concurrent.*;

public class ThreadPoolDirectCreation {

    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2)
        );

        for (int i = 1; i <= 8; i++) {

            int task = i;

            executor.execute(() -> {

                System.out.println("Task " + task + " started by " + Thread.currentThread().getName());

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task " + task + " finished by " + Thread.currentThread().getName());

            });
        }

        executor.shutdown();
    }
}