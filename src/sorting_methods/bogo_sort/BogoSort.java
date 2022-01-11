package sorting_methods.bogo_sort;

import time_measurement.Time;
import java.util.Random;

public class BogoSort {
    private static StringBuilder report;

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
        report = new StringBuilder();
        report.append("Bogo Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
    }

    public static String getReport(){
        return report.toString();
    }
}
