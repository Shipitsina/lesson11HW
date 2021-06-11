package ru.gb.shipHW11;

import ru.gb.shipHW11.fruit.Apple;
import ru.gb.shipHW11.fruit.Fruit;
import ru.gb.shipHW11.fruit.Orange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String [] args){
        daTask1();
        doTask2();
        doTask3();
    }

    private static void daTask1() {
        Fruit [] fruits = {new Apple(), new Orange()};
        changeElementsInArray(fruits, 0, 1);
        for(int i = 0; i<fruits.length; i++)
            System.out.print("[" + fruits[i] + "]");
        System.out.println();
    }

    static void changeElementsInArray(Object [] arr, int i, int j){
        Object temp;
        temp = arr[i];
        arr[i] = arr [j];
        arr[j] = temp;
    }

    private static void doTask2() {
        Fruit [] fruits = {new Apple(), new Orange(), new Apple()};
        System.out.println(toArrayList(fruits));
    }

    static ArrayList <Object> toArrayList(Object [] arr){
        ArrayList <Object> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }



    public static void doTask3(){
        Box <Fruit> box1 = new Box<>();
        Box <Fruit> box2 = new Box<>();

        createFruitBox(box1,'a', getRandomSize(10));
        createFruitBox(box2,'o', getRandomSize(10));

        System.out.println(box1);

        box1.add(new Orange());
        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box1.compare(box2));

        Box <Fruit> box3 = new Box<>();
        Box <Fruit> box4 = new Box<>();

        createFruitBox(box3,'a', 15);
        createFruitBox(box4,'o', 10);

        System.out.println(box3);
        System.out.println(box4);
        System.out.println(box3.compare(box4));

        box3.pour(box1);
        System.out.println(box3);
        System.out.println(box1);

        Box <Fruit> box5 = new Box<>();

        box2.pour(box5);
        System.out.println(box2);
        System.out.println(box5);

    }

    public static void createFruitBox(Box <Fruit> box, char f, int size){
        for (int i = 0; i < size; i++){
            if (f == 'a') box.add(new Apple());
            if (f == 'o') box.add(new Orange());
        }
    }

    public static int getRandomSize(int n){
        Random random = new Random();
        return random.nextInt(n);
    }
}
