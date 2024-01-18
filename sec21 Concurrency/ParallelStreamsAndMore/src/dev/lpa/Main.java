package dev.lpa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Person(String firstName, String lastName, int age){
    private final static String[] firsts = {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};

    private final static  String[] lasts = {"Norton", "Ohara", "Petersen", "Quincy", "Richardson", "Smith"};
    private final static Random random = new Random();
    public Person(){
        this(firsts[random.nextInt(firsts.length)],lasts[random.nextInt(lasts.length)], random.nextInt(18, 100));
    }

    @Override
    public String toString() {
        return "%s, %s (%d)".formatted(lastName, firstName, age);
    }
}
public class Main {
    public static void main(String[] args) {
        var persons = Stream.generate(Person::new)
                        .limit(10)
                                .sorted(Comparator.comparing(Person::lastName))
                                        .toArray();

        for(var person : persons){
            System.out.println(person);
        }
        System.out.println("-".repeat(30));

        Arrays.stream(persons)
                .limit(10)
                .parallel()
//                .sorted(Comparator.comparing(Person::lastName))
                .forEachOrdered(System.out::println);

        System.out.println("-".repeat(30));

        int sum = IntStream.range(1,101)
                .parallel()
                .reduce(0, Integer::sum);

        System.out.println("The sum of the number is: " + sum);

        String humptyDumpty = """
                Humpty Dumpty sat on a wall.
                Humpty Dumpty had a great fall.
                All the king'S horses and all the king'S men
                couldn't put Humpty together again.
                """;

        System.out.println("-".repeat(30));
        var words = new Scanner(humptyDumpty).tokens().toList();
        words.forEach(System.out::println);
        System.out.println("-".repeat(30));

        var backTogetherAgain = words
                .parallelStream()
//                        .reduce("", (s1, s2) -> s1.concat(s2).concat(" "));
                .collect(Collectors.joining(" "));

        System.out.println(backTogetherAgain);

        Map<String, Long> lastNameCounts =
                Stream.generate(Person::new)
                        .limit(10000)
                        .parallel()
                        .collect(Collectors.groupingBy(
                                Person::lastName,
                                Collectors.counting()
                        ));
        lastNameCounts.entrySet().forEach(System.out::println);

        long total = 0;
        for(long count : lastNameCounts.values()){
            total += count;
        }
        System.out.println("Total = " + total);
    }
}