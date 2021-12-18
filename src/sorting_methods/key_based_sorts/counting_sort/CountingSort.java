package sorting_methods.key_based_sorts.counting_sort;

/** CountingSort goes from the fact that an array has its positions always sorted!!!
 * From 0 through its size subtracted one.
 * Let a[] = {1, 0, 2, 1, 0, 1, 1, 5, 6, 7, 5, 4, 2, 2, 0, 0, 1};
 * k = 7 (the greatest value of 'a');
 * n = 17 (size of 'a');
 * The following properties for 'a', are true:
 * Let i = 0, 1, ..., (n - 1), then a[i] <= k
 * Firstly, a[i] ∈ N (if there are negative numbers, another steps must be made!).
 * Now let count be an array of size k + 1: it varies from position 0 through k.
 * In each position of count we should put the frequency of the value in each position in array 'a'.
 *                             0  1  2  3  4  5  6  7
 * It will go like: count[] = {4, 5, 3, 0, 1, 2, 1, 1}.
 * Update count such that count[i + 1] += count[i] to get the right positions to insert the
 * keys into the new sorted array. 'count' will be {4, 9, 12, 12, 13, 15, 16, 17}.
 * Now, check lines 61 forward to know the next steps of this algorithm.
 * Final cost: O(n + k) in so that n = size of 'a' and k = max(a).
 * Let max(array) be a function that returns the maximum value found in an array.
 * Drawbacks:
 * -> In general, this algorithm cannot be applied on negative or floating-point keys!
 *  Even so, you can modify the algorithm to do so.
 * -> If k is too big, time and space complexity will be a polynomial in order of n ^ r where r > 1.
 */

public class CountingSort {
    public static void sort(int[] numbers) {
        int max = 0, mostNegative = 0;
//      Find out who is the maximum value and check if there is at least a negative number: O(n)
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0)
                max = numbers[0];
            else if (numbers[i] > max)
                max = numbers[i];
            if (numbers[i] < mostNegative)
                mostNegative = numbers[i];
        }
//      If mostNegative != 0 it means that we have at least one negative number in 'numbers', and
//      we should normalize our input.
        if (mostNegative != 0) { //Plus O(n) if that is the case!
            mostNegative *= -1; //To use the absolute value of mostNegative!
            for (int i = 0; i < numbers.length; i++)
                numbers[i] += mostNegative;
//          After this loop, we will not have negative numbers anymore.
            max += mostNegative; //We will have to update the size of the array 'count' to a larger one.
//          Remember that we use 'max' to tell how big 'count' is going to be.
        }
//      Count the frequency of each element in 'numbers': O(n)
        int[] count = new int[max + 1];
        for (int i : numbers)
            count[i]++;
//      Each key in 'numbers' will point to an exact position in 'count'.
//      Then, increment this position by one.
//      ------------------------------------------------------------------
//      Update 'count' such that it will contain the last position a key
//      will have to be in the sorted array.
        for (int i = 0; i < count.length - 1; i++)
            count[i + 1] += count[i];
//      Now, let us build our sorted array.
        int[] sorted = new int[numbers.length];
        for (int i = sorted.length - 1; i > -1; i--)  //From last position backwards to maintain stability!
            sorted[--count[numbers[i]]] = numbers[i] - mostNegative;
//      Let me explain what the line above means:
//      -> Access the key at position 'i' in numbers;
//      -> With this key value, check the position in 'count' indexed by this very same value;
//      -> Decrease the value found there to get the actual position the key may be inserted in 'sorted';
//      -> Access 'sorted' with this decreased value and assign to it the key found in numbers[i];
//      -> If we had to normalize 'numbers' (because there was found at least one negative key), we have
//      to subtract the updated key in numbers by the absolute value of mostNegative. See that in line 41
//      we multiplied mostNegative by -1 to put it as its absolute value.
//      ----------------------------------------------------------------------
//      Now, we have got to copy 'sorted' into 'numbers'!
        System.arraycopy(sorted, 0, numbers, 0, sorted.length);
    }
}
