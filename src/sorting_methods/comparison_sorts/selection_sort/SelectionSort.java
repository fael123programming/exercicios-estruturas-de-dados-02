package sorting_methods.comparison_sorts.selection_sort;

import time_measurement.Time;

public class SelectionSort {
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        long moves = 0, comparisons = 0;
        Time.startCounting();
        int aux, posMin;
        comparisons++;
        for (int i = 0; i < numbers.length - 1; i++) {
            posMin = i;
            comparisons++;
            for (int j = i + 1; j < numbers.length; j++) {
                comparisons++;
                if (numbers[j] < numbers[posMin]) {
                    posMin = j;
                }
                comparisons++;
            }
            comparisons++;
            if (i != posMin) {
                aux = numbers[i];
                numbers[i] = numbers[posMin];
                numbers[posMin] = aux;
                moves += 3;
            }
            comparisons++;
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Selection Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
    }

    public static String getReport(){
        return report.toString();
    }
}
