package Design_patterns.enumumenator;

public enum TrafficLight
{
    RED(30),
    YELLOW(5),
    GREEN(25);
    int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    TrafficLight next()
    {
        switch (this)
        {
            case RED:
                return GREEN;

            case GREEN:
                return YELLOW;

            case YELLOW:
                return RED;

            default:
                return RED;
        }
    }

    void display()
    {
        System.out.println(this.duration +" " + this);
    }
}
