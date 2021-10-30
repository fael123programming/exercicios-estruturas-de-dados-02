package sorting_methods.bubble_sort;

public class BubbleSort {
    private static int moves;

    public static void sort(int[] numbers) {
        moves = 0;
        int aux;
        for (int k = 1; k < numbers.length; k++) { //This loop control the quantity of repetitions.
            //k is not used to access elements at all.
            aux = 0; //A flag value to show us when to stop this algorithm.
            for (int i = 0; i < numbers.length - k; i++) {
                //'numbers.length - k' because we don't want to enter the sorted area.
                if (numbers[i] > numbers[i + 1]) { //Let's swap elements according to their size.
                    moves += 3;
                    aux = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = aux;
                    aux = 1; //A flag value indicating that elements needed to be swapped.
                }
            }
            if (aux == 0) break; //If that's true, no elements needed to be swapped at all, so we can stop running it.
        }
    }

    public static int getMoves(){ return BubbleSort.moves; }
}
