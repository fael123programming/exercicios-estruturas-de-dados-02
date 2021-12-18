package sorting_methods.key_based_sorts.radix_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {220, -740, 800, 120, 150, -200, 900};
        System.out.println(Arrays.toString(numbers));
        RadixSort.LSDSort(numbers);
        System.out.println(Arrays.toString(numbers));
//        System.out.println(RadixSort.max(numbers));
//        System.out.println(RadixSort.digits(RadixSort.max(numbers)));
//        for (int i = 0; i < RadixSort.digits(RadixSort.max(numbers)); i++)
//            System.out.println(RadixSort.digitAt(i, RadixSort.max(numbers)));
    }
}
