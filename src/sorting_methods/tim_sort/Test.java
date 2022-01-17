package sorting_methods.tim_sort;

import static sorting_methods.CheckSorting.isSorted;

public class Test {
    public static void main(String[] args) {
        int[] numbers = new int[200000000];
        for (int i = 0; i < 200000000; i++)
            numbers[i] = 200000000 - i;
        TimSort.sort(numbers);
        System.out.println(TimSort.getReport());
        System.out.println(isSorted(numbers));
//      It spent about to 11 secs to sort 200,000,000 numbers
    }
}
