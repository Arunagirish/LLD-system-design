package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue
{
    private Queue<Integer> q;
    int max_capacity;
    BlockingQueue(int max_capacity)
    {
        this.max_capacity = max_capacity;
        q = new LinkedList<>();
    }

    public synchronized void add(int ele) throws InterruptedException {
//        if its if condition, it has already checked. while it was waiting some thread might have removed, now since it don't check it will fail.
        while(this.max_capacity <= q.size())
        {
            System.out.println(Thread.currentThread().getName() + "is waiting");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + "released and acquired lock");
        System.out.println("Adding: "+ele);
        this.q.add(ele);
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while(q.isEmpty())
        {
            System.out.println(Thread.currentThread().getName() + "is waiting");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + "released and acquired lock");
        System.out.println("Removing: ");
        this.q.remove();
//        why notify all instead of notify, with notify it randomly picks the thread(that thread may not be valid, and since there is while loop it will
//        go to waiting, but lets say the valid one is missed, in notify all all will be awakened and checked till valid is found.
        notifyAll();
    }
}

