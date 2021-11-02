package sorting_methods.bogo_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        final int SIZE = 5;
        int[] numbers = new int[SIZE];
        for (int i = SIZE; i > 0; i--) {
            numbers[SIZE - i] = i;
        }
        System.out.println(Arrays.toString(numbers));
        BogoSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(BogoSort.getInfo());
    }
}
