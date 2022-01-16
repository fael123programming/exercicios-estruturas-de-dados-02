package sorting_methods.bucket_sort;

import sorting_methods.bucket_sort.sorting_algorithms.SortingAlgorithm;
import time_measurement.Time;
import java.util.*;

public class BucketSort {
    private static long moves, comparisons;
    private static StringBuilder report;

    public static void sort(int[] numbers, SortingAlgorithm sortingAlgorithm) {
        Time.startCounting();
        int quantityOfBuckets = (int) Math.sqrt(numbers.length);
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        comparisons++;
        for (int i = 0; i < quantityOfBuckets; i++) { //Creating our dynamic buckets!
            buckets.add(new LinkedList<>());
            comparisons++;
        }
        int []maxAndMin = maxAndMin(numbers);
        int range = numbers.length / quantityOfBuckets;
        comparisons++;
        for (int i : numbers) {
            fillBuckets(buckets, 0, i, maxAndMin[1], maxAndMin[1] + range);
            comparisons++;
        }
        sortBuckets(buckets, sortingAlgorithm, numbers);
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Bucket Sort with ").append(sortingAlgorithm.getName()).append("\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    private static void fillBuckets(ArrayList<LinkedList<Integer>> buckets, int bucketIndex, int value, int from, int to) {
        comparisons += 3;
        if (from <= value && value < to || bucketIndex == buckets.size() - 1) {
            buckets.get(bucketIndex).add(value); //Recursion end!
            moves++;
        } else
            fillBuckets(buckets, bucketIndex + 1, value, to, 2 * to - from) ;
    }

    private static void sortBuckets(ArrayList<LinkedList<Integer>> buckets, SortingAlgorithm sortingAlgorithm, int[] srcArray) {
        int[] array;
        int pos = 0;
        comparisons++;
        for (LinkedList<Integer> bucket : buckets) {
            array = castToIntArray(bucket);
            sortingAlgorithm.sort(array);
            comparisons += sortingAlgorithm.getComparisons();
            moves += sortingAlgorithm.getMoves();
            comparisons++;
            for (int number : array) {
                moves++;
                srcArray[pos++] = number;
                comparisons++;
            }
            comparisons++;
        }
    }

    private static int[] castToIntArray(LinkedList<Integer> listOfIntegers) {
        int[] result = new int[listOfIntegers.size()];
        int i = 0;
        comparisons++;
        while (!listOfIntegers.isEmpty()) {
            moves++;
            result[i++] = listOfIntegers.removeFirst();
            comparisons++;
        }
        return result;
    }

//    Get the maximum and minimum values of an array at the same time by cost just of the size of it.
    private static int[] maxAndMin(int[] numbers) {
        int[] maxAndMin = {numbers[0], numbers[0]};
        comparisons++;
        for (int i = 1; i < numbers.length; i++) {
            comparisons += 2;
            if (numbers[i] > maxAndMin[0]) {
                maxAndMin[0] = numbers[i];
                moves++;
            } else if (numbers[i] < maxAndMin[1]) {
                maxAndMin[1] = numbers[i];
                moves++;
            }
            comparisons++;
        }
        return maxAndMin;
    }

    public static String getReport() {
        return report != null ? report.toString() : null;
    }
}
