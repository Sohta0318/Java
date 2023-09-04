package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString(){
     return String.format("%d % s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {
GroceryItem[] groceryItems = new GroceryItem[3];
groceryItems[0] = new GroceryItem("milk");
groceryItems[1] = new GroceryItem("apples", "PRODUCER", 6);
groceryItems[2] = new GroceryItem("oranges", "PRODUCE", 5);
System.out.println(Arrays.toString(groceryItems));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        //        groceryList.add("Yogurt");
        groceryList.add(new GroceryItem("milk"));
        groceryList.add(new GroceryItem("oranges", "PRODUCE", 5));
        groceryList.add(0, new GroceryItem("apples", "PRODUCE", 6));
        groceryList.remove(1);
        System.out.println(groceryList);
    }
}
