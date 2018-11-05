/*
    * This is a Radix Sort implementation that works for arrays with numbers up to 9999.
    * It calls the sort method of CountingSort multiple times on various digit placements to sort the overall numbers.
    * By passing in arguments as divisor and modulo, the correct digit is extracted from the full numbers.
    * This also works for arrays with varying number lengths (e.g. an array with 3, 300, and 3000).
    * This is because (for example) dividing a 3 by 10, the result is truncated to a 0 int value, so the number is effectively sorted as 03.
 */

import java.util.Random;

public class RadixSort {
    public static void main(String[] args){
        Random rng = new Random();
        int[] arr = new int[8]; //defaulting to 8 total numbers for simplicity of reading the output
        for(int i = 0; i < arr.length; ++i){
            arr[i] = rng.nextInt(9999)+1; //generates a number from 1-9999 in each position of arr
        }

        arr = CountingSort.sort(arr, 0, 10); //extracting the ones digit
        printArray(arr, "Sorted by least significant digit:\n[");

        arr = CountingSort.sort(arr, 10, 10); //extracting the tens digit
        printArray(arr, "Sorted by tens place:\n[");

        arr = CountingSort.sort(arr, 100, 10); //extracting the hundreds digit
        printArray(arr, "Sorted by hundreds place:\n[");

        arr = CountingSort.sort(arr, 1000, 0); //extracting the thousands digit
        printArray(arr, "Sorted by most significant digit:\n[");
    }

    private static void printArray(int[] array, String output){
        System.out.print(output);
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i]);
            if(i+1 < array.length)
                System.out.print("|");
        }
        System.out.println("]\n");
    }
}
