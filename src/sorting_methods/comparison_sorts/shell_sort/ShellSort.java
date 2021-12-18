package sorting_methods.comparison_sorts.shell_sort;

//Another version of insertion sort created by Donald Shell.
//Instead of comparing each element with its next, it goes comparing elements
//between a specific distance called 'h'. This distance is decreased as the algorithm
//moves on. It is useful for moderate-size inputs giving a fast execution maybe better
//than insertion sort.
//It is sensible regarding the initial order of the input.
//It is not stable.
//Smaller elements (known as turtle elements) are handled with more efficiency than insertion sort.

import time_measurement.Time;

public class ShellSort {
    private static long comparisons, moves;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        Time.startCounting();
        int h = numbers.length / 2, i, aux, j;
        while (h > 0) {
            comparisons++; //At line 18.
            i = h;
            for (; i < numbers.length; i++) {
                comparisons++; //At line 21.
                aux = numbers[i];
                moves++; //At line 23.
                j = i;
                for (; j >= h && aux < numbers[j - h]; numbers[j] = numbers[j - h], j -= h, comparisons += 2, moves++);
                comparisons += 2; //That comparisons that made this for to break.
                numbers[j] = aux;
                moves++; //At line 28.
            }
            comparisons++; //At line 21 that made that for to break.
            h /= 2; //Integer division: the result will be truncated not rounded.
        }
        Time.finishCounting();
        comparisons++; //At line 18 that made that while to break.
        report = new StringBuilder();
        report.append("Shell Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    public static String getReport() {
        if(report == null)
            return null;
        return report.toString();
    }
}
