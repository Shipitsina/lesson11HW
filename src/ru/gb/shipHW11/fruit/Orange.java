package ru.gb.shipHW11.fruit;

public class Orange extends Fruit{
    private static final float WEIGHT = 1.5f;

    public Orange() {
        super(WEIGHT);
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
