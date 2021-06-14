package ru.gb.shipHW11;

import ru.gb.shipHW11.fruit.Apple;
import ru.gb.shipHW11.fruit.Fruit;
import ru.gb.shipHW11.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit > {

    private ArrayList <T> fruitBox;
   // typeFruit - первый фрукт положенный в пустую коробку, который задает тип этой коробки

    public Box() {
        fruitBox = new ArrayList<>();
    }

    public ArrayList <T> getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }


    public void addFruit(T... fruits) {
        for (T fruit: fruits)
             fruitBox.add(fruit); {

        }
    }
    public void addFruit(List<T> fruits){
        fruitBox.addAll(fruits);
    }

    //Метод возвращает вес фруктов в коробке
    public float boxWeight() {
        if (fruitBox.isEmpty())
            return 0F;
        return fruitBox.size() * fruitBox.get(0).getWeight();
    }

    // Сравниваем вес коробок. В коробках могут быть разные фрукты
    public boolean compare(Box <? extends Fruit> boxToCompare) {
        return boxWeight() == boxToCompare.boxWeight();
    }

    //Пересыпаем из одной коробки в другую

    public void doShoveling (Box <T> boxToShoveling){
        boxToShoveling.getFruitBox().addAll(fruitBox);
        fruitBox.clear();
    }

    @Override
    public String toString() {
            if (fruitBox.isEmpty()) return "Box is empty";
            return "Box for "+ fruitBox.get(0).toString() +"s {" +
                    "number of " + fruitBox.get(0).toString() + " = " + fruitBox.size() + "; " +
                    "box weight = " + boxWeight() +
                    '}';
    }

}
