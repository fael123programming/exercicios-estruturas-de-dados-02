package sorting_methods.merge_sort;

import time_measurement.Time;

public class Test {
    public static void main(String[] args) {
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
