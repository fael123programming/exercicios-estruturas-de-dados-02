package sorting_methods.cocktail_sort;

import static sorting_methods.CheckSorting.isSorted;

public class Test {
    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] numbers = new int[SIZE];
//      Worst case!!!
        for (int i = SIZE; i > 0; i--)
            numbers[SIZE - i] = i;
        CocktailSort.sort(numbers);
        System.out.println(isSorted(numbers));
        System.out.println(CocktailSort.getReport());
    }
}
