package BlockingQueue;

public class ClientCode
{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(1);

        Thread consumerThread = new Thread(()->
        {
            try {
                blockingQueue.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread ProducerThread1 = new Thread(()->
        {
            try {
                blockingQueue.add(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread ProducerThread2 = new Thread(()->
        {
            try {
                blockingQueue.add(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        consumerThread.start();

        Thread.sleep(1000);
        ProducerThread1.start();

        Thread.sleep(1000);
        ProducerThread2.start();
    }
}
