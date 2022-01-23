package sorting_methods.dual_pivot_quicksort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        DualQuicksort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
