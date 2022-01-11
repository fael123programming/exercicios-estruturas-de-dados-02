package sorting_methods.comb_sort;

//Bubble sort was improved and resulted in Combo Sort algorithm.
//The interval of comparison is no longer 1 but calculated based on
//the shrinkage factor (approximately 1.3).

import time_measurement.Time;

public class CombSort {
    private static StringBuilder report;

    public static void sort(int[] numbers, double factor) {
        Time.startCounting();
        long moves = 0, comparisons = 0;
        int interval = numbers.length - 1, i, aux;
        boolean swappedValues = true;
        comparisons += 2; //Next line.
        while (interval > 1 || swappedValues) { //When 'interval' is equal to 1 and none values were swapped, this is going to break.
            comparisons++; //Next line;
            if (interval > 1) {
                interval /= factor; //Decreasing the size of the interval to make comparisons between elements.
                comparisons += 2; //Next line;
                if (interval == 9 || interval == 10) interval = 11; //CombSort11.
            }
            i = 0;
            swappedValues = false;
            comparisons++; //Next line.
            while (interval + i < numbers.length) {
                comparisons++; //Next line.
                if (numbers[i] > numbers[interval + i]) {
                    moves += 3;
                    aux = numbers[i];
                    numbers[i] = numbers[interval + i];
                    numbers[interval + i] = aux;
                    swappedValues = true;
                }
                comparisons++; //Line 28.
                i++;
            }
            comparisons += 2; //Line 18.
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Comb Sort: factor ").append(factor).append("\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
    }

    public static String getReport(){ return report.toString(); }
}
