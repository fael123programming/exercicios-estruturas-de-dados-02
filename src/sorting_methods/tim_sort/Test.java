package sorting_methods.tim_sort;

import time_measurement.Time;

public class Test {
    public static void main(String[] args) {
        int[] numbers = new int[200000000];
        for (int i = 0; i < 200000000; i++)
            numbers[i] = 200000000 - i;
        Time.startCounting();
        TimSort.sort(numbers);
        Time.finishCounting();
        System.out.println(Time.getTime());
//      It spent about to 11 secs to sort 200,000,000 numbers
    }
}
