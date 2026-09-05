package MultiThreading;

public class Client
{
    public static void main(String[] args)
    {
//        using class
        MyTask t1 = new MyTask();
        t1.start();

//        using interface t2 is just task not thread,T2 is thread
        MyTask2 t2 = new MyTask2();
        Thread T2 = new Thread(t2);
        T2.start();
    }
}

//Creating threads using class
class MyTask extends Thread
{
    @Override
    public synchronized void  run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("no "+i+" current thread "+ Thread.currentThread().getName());
        }
    }
}

//Creating threads using interface
class MyTask2 implements Runnable
{
    @Override
    public synchronized void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("no "+i+" current thread "+ Thread.currentThread().getName());
        }
    }
}
