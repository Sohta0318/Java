package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,5, 10,-50,50};
        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        for(String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }
        Arrays.sort(fruit);
System.out.println(Arrays.toString(fruit));

System.out.println("A:" + (int)'A' + " " + "a:" + (int)'a');
        System.out.println("B:" + (int)'B' + " " + "b:" + (int)'b');
        System.out.println("P:" + (int)'P' + " " + "p:" + (int)'p');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("Result = " + tim.compareTo(new Student("TIM")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

        ArrayList<Student> test = new ArrayList<>(List.of(new Student("Zach"), new Student("Tim"), new Student("Ann")));
        test.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(test);
    }
}

class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student>{
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        this.id = LAST_ID++;
        this.gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

    @Override
    public int compareTo(Student o) {
//        return name.compareTo(o.name);
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
}
