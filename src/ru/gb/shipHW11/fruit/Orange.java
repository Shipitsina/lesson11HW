package ru.gb.shipHW11.fruit;

public class Orange extends Fruit{
    private static final float weight = 1.5f;

    public static float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}
