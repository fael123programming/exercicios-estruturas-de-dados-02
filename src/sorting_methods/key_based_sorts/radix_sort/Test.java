package sorting_methods.key_based_sorts.radix_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {1810, 2236, 3559, 9002, 9001, 3, 100, 500, 20, 13};
        RadixSort.MSDSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
