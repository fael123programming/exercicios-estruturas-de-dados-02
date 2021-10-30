package sorting_methods.bubble_sort;

import sorting_methods.selection_sort.SelectionSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(numbers));
        BubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(BubbleSort.getMoves());
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.order(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(selectionSort.getInfo());
        BubbleSort.sort(new int[]{1, 9, 123});
        //This is the best case!
        //The execution flow will stop at the first repetition due flag variable 'aux'.
        BubbleSort.sort(new int[]{900, 1000, 500, 350, 2345});
    }
}
