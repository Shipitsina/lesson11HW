package ru.gb.shipHW11.fruit;

public class Apple extends Fruit{
    private static final float WEIGHT = 1.0f;

    public Apple() {
        super(WEIGHT);
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
