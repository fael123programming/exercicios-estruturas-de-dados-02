package sorting_methods.heap_sort;

import time_measurement.Time;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        final int size = 200000000;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++)
            numbers[i] = size - i;
//        HeapSort.sort(numbers);
//        System.out.println(isIncreasingOrder(numbers));
//        System.out.println(HeapSort.getReport());
        Time.startCounting();
        Arrays.sort(numbers);
        Time.finishCounting();
        System.out.println(Time.getTime());
    }

    private static boolean isIncreasingOrder(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;
        return true;
    }
}
