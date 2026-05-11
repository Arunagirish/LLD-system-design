package Design_patterns.singelton;

public class counter {
    int count = 0;
//    volatile key woard to be used
    private static volatile  counter obj;
    public static counter getinstance()
    {
//        double check in case if both threads are accesed
//        at same time both will pasa the first if
        if(obj == null)
        {
            synchronized(counter.class){
                if(obj == null)
                {
                    obj = new counter();
                    return obj;
                }
            }
        }
        return obj;
    }
    public void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    private counter(){

    }

}
