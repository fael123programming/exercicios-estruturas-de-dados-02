package sorting_methods;

public class CheckSorting {

    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;
        return true;
    }
}
