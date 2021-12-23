package sorting_methods.comparison_sorts.gnome_sort;

import time_measurement.Time;

/**
 * Similar to bubble sort and insertion sort: based on swapping elements towards their right positions.
 * Best case: O(n) where n is the size of the input.
 * Worst case: O(n ^ 2) where n is the size of the input.
 * Analyzing two numbers in an array:
 * -> if a number is greater than its next swap them and go leftward on the array (if you are not at the first
 * position);
 * -> else simply go rightward.
 * Good usages: in a data set where the elements are almost sorted or few new elements were inserted!
 */

public class GnomeSort {
    private static long moves, comparisons;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        if (numbers == null)
            return;
        Time.startCounting();
        int i = 0;
        comparisons++;
        while (i < numbers.length - 1) {
            comparisons++;
            if (numbers[i] > numbers[i + 1]) {
                swap(numbers, i, i + 1);
                moves++;
                comparisons++;
                if (i == 0)
                    i++;
                else i--; //Simple optimization to avoid unnecessary iterations catching the outer else.
            } else i++;
            comparisons++;
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Gnome Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time spent (HH:MM:SS:mm): ").append(Time.getTime()).append("\n");
    }

    private static void swap(int[] srcArray, int pos1, int pos2) {
        int temp = srcArray[pos1];
        srcArray[pos1] = srcArray[pos2];
        srcArray[pos2] = temp;
    }

    public static String getReport() {
        return report == null ? null : report.toString();
    }
}
