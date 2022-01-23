package sorting_methods.dual_pivot_quicksort;

import time_measurement.Time;

public class DualQuicksort {
    private static long moves, comparisons;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        Time.startCounting();
        dualPivotQuicksort(numbers, 0, numbers.length - 1);
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Dual-Pivot Quicksort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    private static void dualPivotQuicksort(int[] numbers, int low, int high) {
        comparisons++;
        if (low >= high)
            return;
        int[] pivots = partition(numbers, low, high);
//      pivots[0] contains the left pivot position.
//      pivots[1] contains the right pivot position.
        dualPivotQuicksort(numbers, low, pivots[0] - 1);
        dualPivotQuicksort(numbers, pivots[0] + 1, pivots[1] - 1);
        dualPivotQuicksort(numbers, pivots[1] + 1, high);
    }

    private static int[] partition(int[] numbers, int low, int high) {
        comparisons++;
        if (numbers[low] > numbers[high])
            swap(numbers, low, high);
        int lp = numbers[low], rp = numbers[high];
//      lp is the left pivot...
//      rp is the right pivot...
        int k = low + 1, g = high - 1, j = low + 1;
        comparisons++;
        while (k <= g) {
            comparisons += 2;
            if (numbers[k] < lp)
                swap(numbers, k, j++);
            else if (numbers[k] >= rp) {
                comparisons += 2;
                while (numbers[g] > rp && k < g) {
                    g--;
                    comparisons += 2;
                }
                swap(numbers, k, g--);
                comparisons++;
                if (numbers[k] < lp)
                    swap(numbers, k, j++);
            }
            k++;
            comparisons++;
        }
        swap(numbers, low, --j);
        swap(numbers, high, ++g);
        return new int[]{j, g};
    }

    private static void swap(int[] array, int pos1, int pos2) {
        comparisons++;
        if (pos1 == pos2)
            return;
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
        moves += 2;
    }

    public static String getReport() {
        return report != null ? report.toString() : null;
    }
}
