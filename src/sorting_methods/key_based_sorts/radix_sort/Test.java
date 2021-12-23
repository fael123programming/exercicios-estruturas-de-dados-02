package sorting_methods.key_based_sorts.radix_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {-10, -11, -12, 678, -13, -15, -14, 0};
        System.out.println(Arrays.toString(numbers));
        RadixSort.LSDSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
