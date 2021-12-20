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
 * Time complexity: O(d * (n + k)) where n is the size of the input, k is the medium size of the keys and d is the quantity
 * of digits of the maximum value (in module) in the input;
 * Space complexity: O(n + k) where n is the size of the input and k is the medium size of the keys.
 */

public class RadixSort {
    public static void MSDSort(int[] numbers) {

    }

    public static void LSDSort(int[] numbers) {
//      Let 'max' be the maximum key found in 'numbers' (not considering sign), then counting sort will be
//      executed the quantity of digits 'max' has.
//      First, get the quantity of digits of the maximum number (in module) in 'numbers' and check whether
//      there is at least one negative number there.
        int executions = digits(maxAbsolute(numbers)); //Counting sorts to do.
        int currentPos = 0; //Current positional digit being sorted and considered.
        int[] count; //Array to contain the frequencies of the digits of the keys.
        final int[] sorted = new int[numbers.length];
        int mostNegative; //To contain, if existent, the less negative digit.
        final int alphabetSize = 10; //From 0 to 9 we have 10 symbols.
        while (executions > 0) {
            mostNegative = 0;
            for (int i : numbers) //Getting the less negative digit of a key, if existent.
                if (digitAt(currentPos, i) < mostNegative)
                    mostNegative = digitAt(currentPos, i);
            mostNegative *= -1; //Putting it as its absolute value.
            count = new int[alphabetSize + mostNegative];
//          We have to build an array of size "alphabetSize + mostNegative" because of our normalization
//          when computing each frequency inside count.
            for (int i : numbers) //Computing the frequencies and normalizing.
                count[digitAt(currentPos, i) + mostNegative]++; //If there is no negative number, this sum will be 0.
            for (int i = 0; i < count.length - 1; i++) //Updating our array of frequencies.
                count[i + 1] += count[i];
            for (int i = numbers.length - 1; i > -1; i--)
                sorted[--count[digitAt(currentPos, numbers[i]) + mostNegative]] = numbers[i];
            System.arraycopy(sorted, 0, numbers, 0, numbers.length);
            executions--;
            currentPos++;
        }
    }

    /**
     * Uses math operations of module and division by 10 to return a digit in a specific
     * position in an integer number.
     *
     * @param position the position of the desired digit in number
     * @param number the integer number to get the digit
     * @return the digit at position "position" in number if existent. If position is < 0, then -1 is returned.
     * If greater than the quantity of digits number has, then 0 is returned.
     */
    private static int digitAt(int position, int number) {
        if (position < 0)
            return -1;
        int digit = number % (int) Math.pow(10, position + 1) / (int) Math.pow(10, position);
        if (position == digits(number) - 1) //The M.S.D of the number.
            return digit; //As it is with sign or not.
        else
            return digit < 0 ? digit * -1 : digit; //Only the M.S.D of a number can carry sign.
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
//      As number / 10 is an integer division it will reach zero in some time.
        return ++digits;
    }

    /**
     * Returns the greatest value (in module) found in an array of integers.
     * @param numbers the array where to search
     * @return the greatest value (in module) found in 'numbers'
     */
    private static int maxAbsolute(int[] numbers) {
        int max = 0, aux;
        for (int i = 0; i < numbers.length; i++) {
            aux = numbers[i] < 0 ? numbers[i] * -1 : numbers[i]; //Absolute value!!!
            if (i == 0)
                max = aux;
            else if (aux > max)
                max = aux;
        }
        return max;
    }
}
