package sorting_methods.merge_sort;

import time_measurement.Time;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] n1 = {11, 1, 10, 2, 9, 3, 8, 4, 2, 11};
        MergeSort.sort(n1);
        System.out.println(Arrays.toString(n1));
        final int SIZE = 173539323;
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = SIZE - i;
        }
        Time.startCounting();
        MergeSort.sort(numbers); //n * log(n)
        Time.finishCounting();
        System.out.println(Time.getTime());
    }
}
