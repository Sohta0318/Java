package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
int[] firstArray = getIntegers(5);
//System.out.println(Arrays.toString(firstArray));
        printArray(sortIntegers(firstArray));
    }
    public static int[] getIntegers(int len){
        Scanner scanner = new Scanner(System.in);
        int count =0;
        int[] newArray = new int[len];
        while(count != len){
            newArray[count] = scanner.nextInt();
            count++;
        }
        return newArray;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
        Arrays.sort(array);
        int[] sortedArray = new int[array.length];
        int count = 0;
        for (int i = array.length -1 ; i >= 0; i--){
            sortedArray[count] = array[i];
            count++;
        }
        return sortedArray;
    }
}
