package Design_patterns.observer;

public class clientcode2
{
    public static void main(String[] args)
    {
        I_observer cond_disp = new CurrentConditionsDisplay();
        I_observer stat = new StatisticsDisplay();

        WeatherStation obj = new WeatherStation();
        obj.set_observer(cond_disp);
        obj.set_observer(stat);

        obj.set_temp(23);
        obj.set_temp(213);
        obj.set_temp(2233);
    }
}
