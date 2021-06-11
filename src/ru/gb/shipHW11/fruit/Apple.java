package ru.gb.shipHW11.fruit;

public class Apple extends Fruit{
    private static final float weight = 1.0f;

    public static float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{}";
    }
}
