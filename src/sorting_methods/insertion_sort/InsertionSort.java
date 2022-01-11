package sorting_methods.insertion_sort;

import time_measurement.Time;

public class InsertionSort {
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        long comparisons = 0, moves = 0;
        Time.startCounting();
        int aux, j;
        comparisons++;
        for (int i = 1; i < numbers.length; i++) {
            aux = numbers[i];
            moves++; //To count the line above.
            comparisons += 2;
            for (j = i; j > 0 && aux < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
                moves++; //To count the line above.
                comparisons += 2;
            }
            numbers[j] = aux;
            moves++; //To count the line above.
            comparisons++;
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Insertion Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
    }

    public static String getReport(){
        return report.toString();
    }

    public static void sort2(int[] numbers) {
        int aux, j;
        for (int i = 1; i < numbers.length; i++) {
            aux = numbers[i];
            for (j = i; j > 0 && aux < numbers[j - 1]; j--)
                numbers[j] = numbers[j - 1];
            numbers[j] = aux;
        }
    }
}
