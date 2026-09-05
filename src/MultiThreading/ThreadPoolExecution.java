package MultiThreading;

import java.util.concurrent.*;

public class ThreadPoolExecution {


    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // -------------------------------
        // 1. execute() -> Runnable
        // -------------------------------
        Runnable runnable = () -> {
            System.out.println("Runnable : " + Thread.currentThread().getName());
        };

        executor.execute(runnable);

        // -------------------------------
        // 2. submit() -> Callable -> Future
        // -------------------------------
        Callable<Integer> callable = () -> {
            System.out.println("Callable : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return 100;
        };

        Future<Integer> future = executor.submit(callable);

        System.out.println("Future Result = " + future.get());

        // -------------------------------
        // 3. CompletableFuture
        // -------------------------------
        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("CompletableFuture : " + Thread.currentThread().getName());
                    return 200;
                }, executor);

        System.out.println("CompletableFuture Result = " + completableFuture.get());

        executor.shutdown();
    }

}
