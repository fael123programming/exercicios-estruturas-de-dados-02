package sorting_methods.key_based_sorts.radix_sort;

import java.util.*;
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
    /**
     * M.S.D (Most Significant Digit) based Radix Sort. It sorts the
     * input evaluating each key digit from left to right.
     * @param numbers the array of numbers to sort
     */
    public static void MSDSort(int[] numbers) {
        int executions;
        int[] group; //An array to contain a group of sorted numbers.
        int[] sorted = new int[numbers.length]; //A list to contain all groups of sorted numbers before copying
//      it into 'numbers'.
//      First, sort all negative numbers.
        int insertablePos = 0; //To contain the next valid index in sort to insert sorted numbers.
        int[] negativeNumbers = getAllNegativeNumbers(numbers);
        if (negativeNumbers != null) { //If that is true, there is at least one negative number to be sorted.
            positivate(negativeNumbers); //Put all negative numbers in module.
            executions = digits(max(negativeNumbers));
            while (executions > 0) {
                group = getArray(negativeNumbers, executions);
                countingSort(group, 0, group.length - 1, executions - 1);
                for (int i = group.length - 1; i > -1; i--)
                    sorted[insertablePos++] = group[i] * -1; //Getting each number back to its original negative sign.
                executions--;
            }
        }
        executions = digits(max(numbers));
        while (executions > 0) {
            group = getArray(numbers, executions);
//          'group' will contain all numbers that have a specific quantity of digits.
//          This quantity of digits is shown by 'executions'.
            countingSort(group, 0, group.length - 1, executions - 1); //Recursive M.S.D counting sort.
            for (int i = group.length - 1; i > -1; i--)
                sorted.addFirst(group[i]);
            executions--;
        }
        ListIterator<Integer> it = sorted.listIterator();
        int j = 0;
        while (it.hasNext())
            numbers[j++] = it.next();
    }

    /**
     * Recursive implementation of counting sort method. This method receives an array
     * of integers and sorts all its numbers using M.S.D radix sort (that is, analyzing
     * each digit from most-left towards most-right). If it encounters two numbers
     * with same first digits, it goes sorting these numbers recursively looking up
     * to the next positional digit differentiating them till they get totally sorted.
     * There is an intrinsic requirement to use this method on your radix sort: the
     * input has to be of numbers that have the same quantity of digits and all of
     * them greater than or equal to zero (non-negative).
     * @param numbers the array of integers to be sorted
     * @param startPos the first position of the array to be considered
     * @param endPos the last position of the array to be considered
     * @param positionalDigit the initial digit to be considered. As standard of this approach,
     * let k be the maximum number found in numbers, positionalDigit would be the quantity
     * of digits k has minus 1.
     * @see #digitAt(int, int)
     */
    private static void countingSort(int[] numbers, int startPos, int endPos, int positionalDigit) {
        if (positionalDigit < 0)
            return; //Recursion base for totally equal numbers!!!
        int[] sorted = new int[endPos - startPos + 1];
        int[] frequencies = new int[10]; //0-9 possible digits.
        for (int i = startPos; i <= endPos; i++) {//Computing frequencies of all digits.
            if (numbers[i] < 0)
                continue;
            frequencies[digitAt(positionalDigit, numbers[i])]++;
        }
        for (int i = 0; i < frequencies.length - 1; i++)
            frequencies[i + 1] += frequencies[i];
        for (int i = endPos; i >= startPos; i--)
            sorted[--frequencies[digitAt(positionalDigit, numbers[i])]] = numbers[i];
        int j;
        for (int i = 0; i < sorted.length - 1; i++) {
            j = i;
            while (j < sorted.length - 1 && digitAt(positionalDigit, sorted[i]) == digitAt(positionalDigit, sorted[j + 1]))
                j++;
            if (i != j) {
                countingSort(sorted, i, j, positionalDigit - 1);
                //Recursive call: sort numbers with same first digits till it gets totally sorted.
                i = j; //To avoid unnecessary iterations.
            }
        }
        System.arraycopy(sorted, 0, numbers, startPos, sorted.length);
    }

    /**
     * L.S.D (the Least Significant Digit) based Radix Sort. It sorts the input evaluating each key digit
     * from left to right.
     * Example of input: 189 890 123
     * First counting sort: sort 9 0 3
     * Second counting sort: sort 8 9 2
     * Third counting sort: sort 1 8 1
     * @param numbers the array of numbers to sort
     */
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
     * position in an integer number. The approach used in this method is the same used
     * to index positions of arrays, that is, if an array has size x then it will vary
     * from position 0 to x - 1.
     * @param position the position of the desired digit in number
     * @param number the integer number to get the digit
     * @return the digit at position "position" in number if existent. If position is < 0, then -1 is returned.
     * If greater than or equal to the quantity of digits number has, then 0 is returned.
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

    private static int max(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers)
            if (number > max)
                max = number;
        return max;
    }

    private static void swap(int[] array, int srcPos, int destPos) {
        if (array == null)
            return;
        if (srcPos < 0 || srcPos > array.length - 1)
            return;
        if (destPos < 0 || destPos > array.length - 1)
            return;
        if (destPos == srcPos)
            return;
        int destValue = array[destPos];
        array[destPos] = array[srcPos];
        array[srcPos] = destValue;
    }

    /**
     * Returns how many numbers with a specific quantity
     * of digits an array has.
     * @param numbers the array where to search
     * @param digits the quantity of digits a number has to have to be countered.
     * @return the quantity of numbers found with the specific quantity of digits.
     */
    private static int numbersWithDigits(int[] numbers, int digits) {
        if (numbers == null || digits <= 0)
            return -1;
        int quantity = 0;
        for (int number : numbers)
            if (digits(number) == digits)
                quantity++;
        return quantity;
    }

    /**
     * Returns a newly created array containing all numbers found
     * in another array with a specific quantity of digits. It
     * ignores negative numbers.
     * @param srcArray the array where to search
     * @param digits the quantity of digits a number need to have
     * @return an array of numbers with a specific quantity
     * of digits
     */
    private static int[] getArray(int[] srcArray, int digits) {
        if (srcArray == null || digits <= 0)
            return null;
        LinkedList<Integer> list = new LinkedList<>();
        for (int number : srcArray) {
            if (number < 0)
                continue;
            if (digits(number) == digits)
                list.addLast(number);
        }
        int[] finalResult = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int j = 0;
        while (it.hasNext())
            finalResult[j++] = it.next();
        return finalResult;
    }

    private static int[] getAllNegativeNumbers(int[] srcArray) {
        LinkedList<Integer> aList = new LinkedList<>();
        for (int number : srcArray)
            if (number < 0)
                aList.addLast(number);
        if (aList.isEmpty())
            return null; //No negative integers found in srcArray.
        ListIterator<Integer> it = aList.listIterator();
        int[] result = new int[aList.size()];
        int j = 0;
        while (it.hasNext())
            result[j++] = it.next();
        return result;
    }

    private static void positivate(int[] srcArray) {
        for (int i = 0; i < srcArray.length; i++)
            if (srcArray[i] < 0)
                srcArray[i] *= -1;
    }
}
