package dev.lpa;

import java.util.*;

record Place(String town, int km) {
    @Override
    public String toString() {
        return String.format("%s (%d)", town, km);
    }
};

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//challenge();
solution();
    }

    public static void challenge() {
        LinkedList<Place> places = new LinkedList<>();
        ListIterator<Place> placeListIterator = places.listIterator();
        places.add(new Place("Adelaide", 1374));
        places.add(new Place("Alice Spring", 2771));
        places.add(new Place("Brisbane", 917));
        places.add(new Place("Darwin", 3974));
        places.add(new Place("Melbourne", 877));
        places.add(new Place("Perth", 3923));


        String menu = """
                Available actions (Select word or letter):
                (F)orward
                (B)ackward 
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        while (true) {
            System.out.println(menu);
            char option = scanner.nextLine().toUpperCase().charAt(0);
            switch (option) {
                case 'F' -> placeListIterator.next();

                case 'B' -> placeListIterator.previous();

                case 'L' -> System.out.println(placeListIterator);

                case 'M' -> System.out.println(menu);
                default -> {
                    return;
                }
            }
        }
    }

    public static void solution(){
        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placesToVisit, adelaide);
        addPlace(placesToVisit,new Place("Alice Spring", 2771));
        addPlace(placesToVisit,new Place("Brisbane", 917));
        addPlace(placesToVisit,new Place("Darwin", 3974));
        addPlace(placesToVisit,new Place("Melbourne", 877));
        addPlace(placesToVisit,new Place("Perth", 3923));

        placesToVisit.addFirst(new Place("Sydney", 0));
        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while(!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Originating " + iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()){
                System.out.println("Final " + iterator.previous());
                forward = false;
            }
            System.out.println("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);
            switch(menuItem){
                case "F" -> {
                    System.out.println("User wants to go forward");
                    if(!forward){    // Reversing direction
                        forward = true;
                        if(iterator.hasNext()){   // Adjusting position backwards
                            iterator.next();
                        }
                    }

                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                }
                case "B" -> {
                    System.out.println("User wants to go backwards");
                    if(forward){    // Reversing direction
                        forward = false;
                        if(iterator.hasPrevious()){   // Adjusting position forward
                            iterator.previous();
                        }
                    }

                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                }
                case "M" -> {
                    printMenu();
                    break;
                }
                case "L" -> {
                    System.out.println(placesToVisit);
                    break;
                }
                default -> {
                    quitLoop = true;
                    break;
                }
            }
        }
    }

    public static void addPlace(List<Place> list, Place place){
//        if(list.contains(place)){
//            System.out.println("Found duplicate: " + place);
//            return;
//        }
        for(Place i : list){
            if(i.town().equalsIgnoreCase(place.town())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }

        int matchIndex = 0;
        for(var listPlace : list){
            if(place.km() < listPlace.km()){
                list.add(matchIndex, place);
                return;
            }
            matchIndex++;
        }
        list.add(place);
    }

    public static void printMenu(){
        System.out.println("""
                Available actions (Select word or letter):
                (F)orward
                (B)ackward 
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}
