package MultiThreading;

import java.util.concurrent.*;

public class ThreadPoolFactoryCreation {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 6; i++) {

            int task = i;

            executor.execute(() -> {

                System.out.println(
                        "Task " + task +
                                " running on " +
                                Thread.currentThread().getName());

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }

            });
        }

        executor.shutdown();
    }
}