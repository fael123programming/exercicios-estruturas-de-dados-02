package sorting_methods.bogo_sort;

import time_measurement.Time;

import java.util.Random;

public class BogoSort {
    private static String info;

    public static void sort(int[] numbers) {
        Time.startCounting();
        long moves = 0, comparisons = 0;
        Random rd = new Random();
        boolean sorted = false;
        int randomPos, aux;
        comparisons++; //Next line.
        while (!sorted) {
            sorted = true;
            comparisons++; //Next line.
            for (int i = 0; i < numbers.length - 1; i++) { //It checks whether 'numbers' is sorted or not.
                comparisons++; //Next line.
                if (numbers[i] > numbers[i + 1]) {
                    sorted = false;
                    break;
                }
                comparisons++; //Line 20.
            }
            comparisons++; //Next line.
            if (!sorted) {
                comparisons++; //Next line.
                for (int j = 0; j < numbers.length; j++) {
                    randomPos = rd.nextInt(numbers.length);
                    moves += 3;
                    aux = numbers[j];
                    numbers[j] = numbers[randomPos];
                    numbers[randomPos] = aux;
                    comparisons++; //Line 31.
                }
            }
            comparisons++; //Line 17.
        }
        Time.finishCounting();
        info = String.format("Elements: %d%nMovements: %d%nComparisons: %d%nTime spent: %s",numbers.length, moves,
                comparisons, Time.getTime());
    }

    public static String getInfo(){
        return info;
    }
}
