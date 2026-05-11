package Design_patterns.observer;

public interface I_observer
{
    void update(WeatherStation station);
}


class CurrentConditionsDisplay  implements I_observer
{

    @Override
    public void update(WeatherStation station) {
        System.out.println(station.temp);
    }
}

class StatisticsDisplay   implements I_observer
{
    @Override
    public void update(WeatherStation station)
    {
        System.out.println(station.temp);
    }
}
