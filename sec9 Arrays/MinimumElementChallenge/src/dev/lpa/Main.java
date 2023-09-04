package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
int[] firstArray = readIntegers();
System.out.println(Arrays.toString(firstArray));
int min = findMin(firstArray);
System.out.println("Minimum number = " + min);
    }

    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String input = scanner.nextLine();
        String[] splits = input.split(",");
        int[] newArray = new int[splits.length];
        for(int i = 0; i < splits.length; i++){
            newArray[i] = Integer.parseInt(splits[i].trim());
        }
        return newArray;
    }
    public static int findMin(int[] array){
        int min = array[0];
        for(int i : array){
            min = Math.min(min, i);
        }
        return min;
    }
}
