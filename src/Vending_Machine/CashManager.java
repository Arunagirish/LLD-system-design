package Vending_Machine;

public class CashManager
{
    int no_of_fives;
    int no_of_twos;
    int no_of_ones;
    CashManager(int no_of_fives, int no_of_twos, int no_of_ones)
    {
        this.no_of_fives = no_of_fives;
        this.no_of_twos = no_of_twos;
        this.no_of_ones = no_of_ones;
    }
    void add_coin(Coin coin)
    {
       switch (coin.value)
        {
            case 5: no_of_fives++;
            case 2: no_of_twos++;
            case 1: no_of_ones++;
        }
    }
    boolean is_sufficient(int change)
    {
        int fives = Coin.FIVE.value * no_of_fives;
        int twos = Coin.TWO.value * no_of_twos;
        int ones = Coin.ONE.value * no_of_ones;
        if(fives+twos+ones >= change)return true;
        return false;

    }

    void get_change(int change)
    {

        if(change >= Coin.FIVE.value && no_of_fives != 0)
        {
            while(change/Coin.FIVE.value > 0)
            {
                change -= Coin.FIVE.value;
                no_of_fives--;
            }
        }
        if(change >= Coin.TWO.value && no_of_twos != 0)
        {
            while(change/Coin.TWO.value > 0)
            {
                change -= Coin.TWO.value;
                no_of_twos--;
            }
        }
        if(change >= Coin.ONE.value && no_of_ones != 0) {
            while (change / Coin.ONE.value > 0) {
                change -= Coin.ONE.value;
                no_of_ones--;
            }
        }
    }
}
