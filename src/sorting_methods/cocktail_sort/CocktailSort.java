package sorting_methods.cocktail_sort;

import time_measurement.Time;

public class CocktailSort {
    private static long moves, comparisons;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        Time.startCounting();
        int left = 0, right = numbers.length, lastSwap = 0;
        while (true) {
            comparisons++;
            for (int i = left; i < right - 1; i++) {
                comparisons++;
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    lastSwap = i + 1;
                }
                comparisons++;
            }
            right = lastSwap;
            comparisons++;
            if (left == right)
                break;
            comparisons++;
            for (int i = right - 1; i >= left; i--) {
                comparisons++;
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    lastSwap = i + 1;
                }
                comparisons++;
            }
            left = lastSwap;
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Cocktail Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    private static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
        moves++;
    }

    public static String getReport() {
        return report != null ? report.toString() : null;
    }
}
