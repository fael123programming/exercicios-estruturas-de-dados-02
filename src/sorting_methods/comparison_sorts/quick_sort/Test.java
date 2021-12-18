package sorting_methods.comparison_sorts.quick_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        final int n = 100;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = n - i;
        QuickSort.enhancedSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
