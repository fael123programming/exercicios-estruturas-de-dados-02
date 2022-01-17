package sorting_methods.tim_sort;

//The main idea of this algorithm is the following:
//-> We break our input down into smaller pieces of data sets that are with a good percentage of order;
//-> After, we apply Insertion Sort (or a similar algorithm like Bubble Sort) on these groups of data;
//-> Finally, Merge Sort is used to merge all those sets together making our input array sorted.
//Main principles:
//-> Use two sorting algorithms on their most optimized versions. They are, namely,
//Insertion Sort and Merge Sort;
//-> Divide your input array into smaller chunks of numbers;
//Here there is a point: these chunks must be of size 32 up to 64 (2 ^ 5 up to 2 ^ 6);
//Why? Insertion Sort works better with arrays of this size!

import time_measurement.Time;

public class TimSort {
    public static final int MIN_MERGE = 32;
    private static StringBuilder report;
    private static long moves, comparisons;

    public static void sort(int[] numbers) {
        Time.startCounting();
        int minRun = minRunLength(MIN_MERGE); //minRun tells us the step we will run through our main array. 16
        comparisons++;
        for (int i = 0; i < numbers.length; i += minRun) {
            insertionSort(numbers, i, Math.min(i + MIN_MERGE - 1, numbers.length - 1));
            comparisons++;
        }
        int mid, right;
        comparisons++;
        for (int i = minRun; i < numbers.length; i *= 2) {
            comparisons++;
            for (int left = 0; left < numbers.length; left += 2 * i) {
                mid = left + i - 1;
                right = Math.min(left + 2 * i - 1, numbers.length - 1);
                comparisons++;
                if (mid < right)
                    merge(numbers, left, mid, right);
                comparisons++;
            }
            comparisons++;
        }
        Time.finishCounting();
        report = new StringBuilder();
        report.append("Tim Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    /**
     * This method returns the size of each sub-array to divide the main input array into.
     * It uses bitwise operators ('OR' and 'AND') to calculate this value based on the bits
     * of the argument passed to.
     *
     * @param value the size of the main array to be sorted
     * @return the size of each sub-array to divide the main array. It will never be greater
     * than MIN_MERGE
     */
    public static int minRunLength(int value) {
        if (value < 0)
            throw new IllegalArgumentException("Value " + value + " must be non-negative");
        int aux = 0;
        comparisons++;
        while (value >= MIN_MERGE) {
            aux |= (value & 1);
//          Bitwise operator '&': it does logical AND operation with all bits of value and 1.
//          Bitwise operator '|': it does logical OR operation with all bits of aux and the result of 'value & 1'.
            value >>= 1; //Dividing value by two; same as 'value /= 2'
            comparisons++;
        }
        return value + aux; //'value + aux' will never be greater than MIN_MERGE.
    }

    /**
     * Insertion sort algorithm to sort an array from one position of it
     * towards another
     *
     * @param array the array to be sorted
     * @param from  the starting position to begin sorting
     * @param to    the end position to sort
     */
    private static void insertionSort(int[] array, int from, int to) {
        int aux, j;
        comparisons++;
        for (int i = from + 1; i <= to; i++) {
            aux = array[i];
            comparisons += 2;
            for (j = i - 1; j >= from && aux < array[j]; j--) {
                moves++;
                array[j + 1] = array[j];
                comparisons += 2;
            }
            moves++;
            array[j + 1] = aux;
            comparisons++;
        }
    }

    private static void merge(int[] array, int from, int mid, int to) {
        int leftSize = mid - from + 1, rightSize = to - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
//      Filling up our arrays with the values from 'array'.
//      Each one will have a half of it.
        comparisons++;
        for (int i = 0; i < leftSize; i++) {
            moves++;
            left[i] = array[from + i];
            comparisons++;
        }
        comparisons++;
        for (int i = 0; i < rightSize; i++) {
            right[i] = array[mid + i + 1];
            moves++;
            comparisons++;
        }
//      Aux variables to the merging process. They are used for accessing positions in our arrays.
        int l = 0, r = 0, a = from;
//      Comparing each value found in our arrays and merging them into 'array' in increasing order.
//      See that this is an in-place process.
        comparisons += 2;
        while (l < leftSize && r < rightSize) {
            comparisons++;
            if (left[l] <= right[r])
                array[a++] = left[l++];
            else
                array[a++] = right[r++];
            moves++;
            comparisons += 2;
        }
//      If any values are still remaining in one of our arrays we have to force their transference to 'array'.
//      Only one while will be executed.
        comparisons++;
        while (l < leftSize) {
            array[a++] = left[l++];
            comparisons++;
            moves++;
        }
        comparisons++;
        while (r < rightSize) {
            array[a++] = right[r++];
            comparisons++;
            moves++;
        }
    }

    public static String getReport() {
        return report.toString();
    }
}
