package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {
int len = readInteger();
int[] array1 = readElements(len);
System.out.println(Arrays.toString(array1));
System.out.println(findMin(array1));
    }
    private static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static int[] readElements(int len){
        Scanner scanner = new Scanner(System.in);
        int[] newArray = new int[len];
        for(int i =0; i < len; i++){
            newArray[i] = scanner.nextInt();
        }
        return newArray;
    }
    private static int findMin(int[] array){
        int min = array[0];
        for(int el: array){
            min = Math.min(el,min);
        }
        return min;
    }
}
