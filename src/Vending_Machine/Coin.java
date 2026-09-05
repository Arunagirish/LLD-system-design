package Vending_Machine;

public enum Coin {
    FIVE(5),
    TWO(2),
    ONE(1);

    int value;
    Coin(int value) {
        this.value = value;
    }
}
