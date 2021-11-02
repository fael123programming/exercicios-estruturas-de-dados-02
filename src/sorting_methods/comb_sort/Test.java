package sorting_methods.comb_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        final int SIZE = 50000000;
        int[] numbers = new int[SIZE];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = SIZE - i;
        }
        //System.out.println(Arrays.toString(numbers));
        CombSort.sort(numbers, 1.3);
        System.out.println(Arrays.toString(numbers));
        System.out.println(CombSort.getInfo());
    }
}
