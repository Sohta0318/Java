package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int[] firstArray = getRandomArrays(5);
//        Arrays.sort(firstArray);
//        System.out.println(Arrays.toString(firstArray));
//        System.out.println(Arrays.toString(desSort(firstArray)));
        int[] sortedArray = sortIntegers(new int[] {7,30,35});
        System.out.println(Arrays.toString(sortedArray));


    }

    public static int[] getRandomArrays(int len){
        Random random = new Random();
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++){
            newArray[i] = random.nextInt(100);
        }
        return newArray;
    }
    public static int[] desSort(int[] array){
        Arrays.sort(array);
        int[] decArray = new int[array.length];
        int count = 0;
        for (int i = array.length - 1; i >= 0 && count != array.length; i--){
            decArray[count] = array[i];
            count++;
        }
        return decArray;
    }

    private static int[] sortIntegers(int[] array){

        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i < sortedArray.length -1; i++){
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("----->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("-->" + Arrays.toString(sortedArray));

        }
        return sortedArray;
    }
}
