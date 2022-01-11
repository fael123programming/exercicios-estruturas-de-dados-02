package sorting_methods.bubble_sort;

//Best case: of a linear function regarding the size of the input (n);
//Worst case: of a quadratic function regarding the size of the input (n ^ 2).
//Not useful for large inputs!

import time_measurement.Time;

public class BubbleSort {
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        Time.startCounting();
        long moves = 0, comparisons = 0;
        int aux;
        comparisons++; //Next line.
        for (int k = 1; k < numbers.length; k++) {
            //This loop control the quantity of repetitions.
            //k is not used to access elements.
            //It repeats from 1 to numbers.length - 1 because when only one number last, the whole input
            //is already sorted.
            aux = 0; //A flag value to show us when to stop this algorithm.
            comparisons++; //Next line.
            for (int i = 0; i < numbers.length - k; i++) {
                //'numbers.length - k' because we don't want to enter the sorted area.
                comparisons++; //Next line.
                if (numbers[i] > numbers[i + 1]) { //Let's swap elements according to their size.
                    moves += 3;
                    aux = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = aux;
                    aux = 1; //A flag value indicating that elements needed to be swapped.
                }
                comparisons++;
            }
            comparisons++; //Next line.
            if (aux == 0) break; //If that's true, no elements needed to be swapped at all, so we can stop running it.
            comparisons++; //Line 17.
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Bubble Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
    }

    public static void sort2(int[] numbers) { //Another implementation using do/while.
        int aux, k = numbers.length;
        boolean goOn;
        do {
            goOn = false;
            for (int i = 0; i < k - 1; i++)
                if (numbers[i] > numbers[i + 1]) {
                    aux = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = aux;
                    goOn = true;
                }
        } while (goOn);
    }

    public static String getReport(){ return report.toString(); }
}
