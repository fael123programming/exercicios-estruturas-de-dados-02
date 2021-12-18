package sorting_methods.key_based_sorts.radix_sort;

/**
 * Radix sort is a sorting algorithm that uses the own characteristics of each item it has to sort to do its job.
 * It is used in conjunction with counting sort to analyze smaller elements: counting sort is applied on the input
 * digit by digit of each key. Generally, it is very fast and has stability.
 * It breaks down all keys (numbers, set of characters, etc.) in indivisible pieces (from right to left or from left
 * to right) analysing each radix and sorting them till the whole group of keys is sorted.
 * There are two versions of radix sort: MSD (Most Significant Digit) based and LSD (Least Significant Digit) based;
 * MSD: evaluates the keys as with strings of characters (lexicographically);
 * LSD: evaluates the keys as with integer numbers (from right places to left ones).
 * Time cost:
 * LSD: O(n*k) where n is the size of the input and k is the medium size of the keys;
 */

public class RadixSort {
    public static void MSDSort(int[] numbers) {

    }

    public static void LSDSort(int[] numbers) {
//      Let 'max' be the maximum key found in 'numbers', then counting sort will be
//      executed the quantity of digits 'max' has.
//      First, get the maximum number in numbers and check whether there is at least one negative number in 'numbers'.
        int max = max(numbers);
        int executions = digits(max); //Counting sorts to do.
        int currentPos = 0; //Current digit being sorted and considered.
        int[] count; //Array to contain the frequencies of the digits of the keys.
        int[] sorted = new int[numbers.length];
        int mostNegative = 0;
        while (executions > 0) {
            if (executions == 1) {
//             If we get here, it means that we are analyzing the MSD of each key.
//             This is the only digit that can have the "-" sign.
                for (int i : numbers)
                    if (digitAt(currentPos, i) < mostNegative)
                        mostNegative = digitAt(currentPos, i);
                mostNegative *= -1;
                count = new int[10 + mostNegative];
            } else count = new int[10];
            for (int i : numbers) //Computing the frequencies.
                count[digitAt(currentPos, i) + mostNegative]++;
            for (int i = 0; i < count.length - 1; i++) //Updating our array of frequencies.
                count[i + 1] += count[i];
            for (int i = numbers.length - 1; i > -1; i--)
                sorted[--count[digitAt(currentPos, numbers[i]) + mostNegative]] = numbers[i];
            System.arraycopy(sorted, 0, numbers, 0, numbers.length);
            executions--;
            currentPos++;
        }
        System.arraycopy(sorted, 0, numbers, 0, numbers.length);
    }

    /**
     * Uses math operations of module and division by 10 to return a digit in a specific
     * position in an integer number.
     *
     * @param position the position of the desired digit in number
     * @param number   the integer number to get the digit
     * @return the digit at position "position" in number if existent. If position is < 0, then -1 is returned.
     * If greater than the quantity of digits number has, then 0 is returned.
     */
    private static int digitAt(int position, int number) {
        if (position < 0)
            return -1;
        return number % (int) Math.pow(10, position + 1) / (int) Math.pow(10, position);
    }

    /**
     * Returns the quantity of digits a specific integer number has
     * based on how many integer divisions by ten it can bear till it
     * is reduced to zero.
     * @param number the number to calculate how many digits it has
     * @return the quantity of digits number has
     */
    private static int digits(int number) {
        if (number < 0)
            number *= -1;
        int digits = 0;
        for (; (number /= 10) > 0; digits++);
        return ++digits;
    }

    /**
     * Returns the greatest value found in an array of integers.
     * @param numbers the array where to search
     * @return the greatest value found in the array numbers
     */
    private static int max (int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0)
                max = numbers[0];
            else if (numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }
}
