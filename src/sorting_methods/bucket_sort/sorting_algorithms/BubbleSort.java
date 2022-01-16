package sorting_methods.bucket_sort.sorting_algorithms;

public class BubbleSort implements SortingAlgorithm {
    private long moves, comparisons;

    @Override
    public void sort(int[] numbers) {
        int aux, k = numbers.length;
        boolean goOn;
        moves = 0;
        comparisons = 0;
        do {
            goOn = false;
            this.comparisons++;
            for (int i = 0; i < k - 1; i++) {
                this.comparisons++;
                if (numbers[i] > numbers[i + 1]) {
                    aux = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = aux;
                    this.moves += 2;
                    goOn = true;
                }
                this.comparisons++;
            }
            this.comparisons++; //Next line.
        } while (goOn);
    }

    @Override
    public long getMoves() {
        return this.moves;
    }

    @Override
    public long getComparisons() {
        return this.comparisons;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
