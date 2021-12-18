package sorting_methods.key_based_sorts.counting_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] numbers = new int[100];
        for (int i = 1; i < 101; i++)
            numbers[i - 1] = 50 - i;
        System.out.println(Arrays.toString(numbers));
        CountingSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
