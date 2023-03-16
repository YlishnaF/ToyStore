package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    static List<String> toyNames = new ArrayList<>();
    List<Toy> toys = new ArrayList<>();
    private static int amount = 10;

    static {
        toyNames.add("Teddy");
        toyNames.add("Dog");
        toyNames.add("Cat");
        toyNames.add("Rabbit");

    }

    public Store() {
        createToys();
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.bayToy(4);
        System.out.println(store.toys);
        store.addToy();
        System.out.println(store.toys);

    }

    public void createToys() {
        for (int i = 0; i < getAmount(); i++) {
            int n = (int) (Math.random() * toyNames.size());
            toys.add(new Toy(i, toyNames.get(n)));
        }
    }

    public void bayToy(int index) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("store.txt"));
            bw.write("Куплена игрушка " + toys.get(index).toString());
            amount--;
            if (index < toys.size()) {
                toys.remove(index);
            } else {
                System.out.println("Игрушки нет, выберите другую");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToy(){
        amount++;
        int n = (int) (Math.random() * toyNames.size());
        toys.add(new Toy(amount-1, toyNames.get(n)));

    }

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        amount = amount;
    }
}
