package exercises.insertion_x_merge;

import sorting_methods.insertion_sort.InsertionSort;
import sorting_methods.merge_sort.MergeSort;
import time_measurement.Time;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] n1 = new int[32], n2 = new int[32], n3 = new int[64], n4 = new int[64];
        for (int i = 32; i > 0; i--) {
            n1[32 - i] = i;
            n2[32 - i] = i;
        }
        for (int i = 64; i > 0; i--) {
            n3[64 - i] = i;
            n4[64 - i] = i;
        }
//------------------------------------------------------------------------------------------
        Time.startCounting();
        InsertionSort.sort2(n1);
        Time.finishCounting();
        System.out.println("Insertion sort with 32 numbers: " + Time.getTime());
        System.out.println(Arrays.toString(n1));
        Time.startCounting();
        InsertionSort.sort2(n3);
        Time.finishCounting();
        System.out.println("Insertion sort with 64 numbers: " + Time.getTime());
        System.out.println(Arrays.toString(n3));
//-------------------------------------------------------------------------------------------
        Time.startCounting();
        MergeSort.sort2(n2);
        Time.finishCounting();
        System.out.println("Merge sort with 32 numbers: " + Time.getTime());
        System.out.println(Arrays.toString(n2));
        Time.startCounting();
        MergeSort.sort2(n4);
        Time.finishCounting();
        System.out.println("Merge sort with 64 numbers: " + Time.getTime());
        System.out.println(Arrays.toString(n4));
    }
}
