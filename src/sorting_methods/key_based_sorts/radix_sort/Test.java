package sorting_methods.key_based_sorts.radix_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {-67, 345, 90, 0, -100, -678, -5, -3, -8976, -10, -352354341, -100, -450};
        System.out.println(Arrays.toString(numbers));
        RadixSort.LSDSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
