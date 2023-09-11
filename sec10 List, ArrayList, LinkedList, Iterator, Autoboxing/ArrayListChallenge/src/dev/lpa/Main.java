package dev.lpa;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        challenge();
        solution();
    }
    public static void challenge(){
        ArrayList<String> groceries = new ArrayList<>();
        while(true){
            System.out.println("""
                    Available action:
                    0 - shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove items (comma delimited list)
                    Enter a number for which action you want to do:
                    """);
            String menu = scanner.nextLine();
            String[] stringArr = menu.split(",");
            int action = Integer.parseInt(stringArr[0]);

            switch(action){
                case 1 -> {
                    for(int i = 1; i < stringArr.length; i++){
                        if(groceries.contains(stringArr[i])){
                            System.out.println("Already exist!");
                        }else {
                            groceries.add(stringArr[i]);
                        }
                    }
                }
                case 2 ->{
                    for(int i = 1; i < stringArr.length; i++) {
                       groceries.remove(stringArr[i]);
                    }
                }
                default -> {
                    return;
                }
            }
            System.out.println(groceries);
        }
    }
    public static void solution(){
boolean flag = true;
ArrayList<String> groceries = new ArrayList<>();
while(flag){
    printAction();
    switch (Integer.parseInt(scanner.nextLine())){
        case 1 -> addItem(groceries);
        case 2 -> removeItem(groceries);
        default -> flag = false;
    }
    groceries.sort(Comparator.naturalOrder());
    System.out.println(groceries);
}
    }

    public static void addItem(ArrayList<String> groceries){
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));

        for(String i : items){
            String trimmed = i.trim();
            if(groceries.indexOf(trimmed) < 0) {
                groceries.add(trimmed);
            }
        }
    }

    public static void removeItem(ArrayList<String> groceries){
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));

        for(String i : items){
            String trimmed = i.trim();
                groceries.remove(trimmed);
        }
    }
    public static void printAction(){
        String textBlock = """
                    Available action:
                    0 - shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove items (comma delimited list)
                    Enter a number for which action you want to do:
                    """;
        System.out.println(textBlock+ " ");
    }
}
