package ru.gb.shipHW11;

import ru.gb.shipHW11.fruit.Apple;
import ru.gb.shipHW11.fruit.Fruit;
import ru.gb.shipHW11.fruit.Orange;

import java.util.ArrayList;

public class Box <T extends Fruit > {
    
    private ArrayList <T> fruitBox = new ArrayList<>();
   // typeFruit - первый фрукт положенный в пустую коробку, который задает тип этой коробки
    private T typeFruit;


    public ArrayList <T> getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public void setTypeFruit(T typeFruit) {
        this.typeFruit = typeFruit;
    }

    public void add(T newFruit) {
        //В пустую коробку кладем фрукт и в typeFruit присваиваем ссылку на этот первый в коробке фрукт
        if (fruitBox.isEmpty()){
            typeFruit = newFruit;
            fruitBox.add(newFruit);
        }
        //А если коробка не пустая, делаем проверку какой фрукт там уже лежит, если такой же - добавляем
        else if (checkFruit(newFruit))
            fruitBox.add(newFruit);
        else System.out.println("Your can't put this fruit - this box is for another fruits!");
    }

    //Метод сверяет первый в коробке фрукт с новым фруктом
    private boolean checkFruit(T fruit) {
        return typeFruit.getClass() == fruit.getClass();
    }

    //Метод возвращает вес фруктов в коробке
    public float boxWeight() {
            return fruitBox.size() * fruitWeight();
    }

    //Сомнительный метод, возвращающий вес первого фрукта, положенного в коробку
    private float fruitWeight() {
        if (typeFruit instanceof Orange) return Orange.getWeight();
        if (typeFruit instanceof Apple) return Apple.getWeight();
        return 0;
    }

    // Сравниваем вес коробок. В коробках могут быть разные фрукты
    public boolean compare(Box boxToCompare) {
        return boxWeight() == boxToCompare.boxWeight();
    }

    //Пересыпаем из одной коробки в другую
   public void pour (Box <T> boxToShoveling){
        // Пересыпать можно только, если есть, что пересыпать
        if (!fruitBox.isEmpty()){
        // Если коробка пуста - смело пересыпаем
            if (boxToShoveling.getFruitBox().isEmpty()){
                boxToShoveling.setTypeFruit(typeFruit);
                doShoveling(boxToShoveling);
            } else
             // если не пуста, проверяем на одинаковость фруктов и пересыпаем
                if (checkFruit(boxToShoveling.typeFruit))
                    doShoveling(boxToShoveling);
                // Иначе не можем пересыпать
                else System.out.println("Can't pour fruits into this box");
        }
    }

    //Нпосредственно сам процесс. 1 Добавили в коробку все из текущей, а в текущую очистили
    private void doShoveling (Box <T> boxToShoveling){
        boxToShoveling.getFruitBox().addAll(fruitBox);
        fruitBox.clear();
    }

    @Override
    public String toString() {
            if (fruitBox.isEmpty()) return "Box is empty";
            String type = getType();
            return "Box for "+ type +" {" +
                    "number of " + type + " = " + fruitBox.size() + "; " +
                    "box weight = " + boxWeight() +
                    '}';
    }

    private String getType() {
        if (isAppleBox()) return "apples";
        if (isOrangeBox()) return "oranges";
        return "some fruits";
    }

    private boolean isAppleBox() {
        return (fruitBox.get(0) instanceof Apple);
    }

    private boolean isOrangeBox() {
        return (fruitBox.get(0) instanceof Orange);
    }
}
