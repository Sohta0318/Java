package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
int[] numArray = {1,2,3,4,5};
//reverseArray(numArray);
//System.out.println("Reversed Array = " + Arrays.toString(numArray));

        int[] reversedCopy = reverseCopy(numArray);
        System.out.println("After reverse" + Arrays.toString(numArray));
        System.out.println("reverse Copy" + Arrays.toString(reversedCopy));

    }
    private static int[] reverseArray(int[] array){
        for (int i = 0; i < array.length / 2; i++){
            int temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
            System.out.println("-->" + Arrays.toString(array));
        }
        return array;
    }

    private static int[] reverseCopy(int[] array){
        int[] reversedArray = new int[array.length];
        int maxIndex = array.length-1;
        for(int el: array){
            reversedArray[maxIndex--] = el; // maxIndex-- occur after complete assigning
        }
        return reversedArray;
    }
}
