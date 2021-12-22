package sorting_methods.key_based_sorts.radix_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {-678, 1000, 678, 679};
        System.out.println(Arrays.toString(numbers));
        RadixSort. MSDSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
