package Design_patterns.observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation
{
    public int temp;
    private List<I_observer> observerList;

    public  void set_observer(I_observer obs)
    {
        observerList.add(obs);
    }

    public  void remove_observer(I_observer obs)
    {
        for(I_observer obj: observerList)
        {
            if(obj == obs)observerList.remove(obs);
        }
    }

    private void ntify()
    {
        for (I_observer observer : observerList) {
            observer.update(this); // notify each observer
        }
    }

    public void set_temp(int temp)
    {
        this.temp = temp;
        ntify();
    }

    public WeatherStation()
    {
        observerList = new ArrayList<>();
    }
}
