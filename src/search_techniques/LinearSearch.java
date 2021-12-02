package search_techniques;

import java.util.Arrays;

public class LinearSearch {
    public static int search(int wanted, int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == wanted)
                return i;
        return -1; //Not found.
    }

    public static int searchOrdered(int wanted, int[] numbers) {
        Arrays.sort(numbers); //Ordering it increasingly before searching using Dual-Pivot Quick Sort.
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] < wanted)
                i++;
            else
                break;
        }
        if (numbers[i] == wanted)
            return i;
        else
            return -1;
    }
}
