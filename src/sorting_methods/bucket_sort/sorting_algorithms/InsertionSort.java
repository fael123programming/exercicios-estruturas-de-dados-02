package sorting_methods.bucket_sort.sorting_algorithms;

public class InsertionSort implements SortingAlgorithm {
    private long moves, comparisons;

    @Override
    public void sort(int[] numbers) {
        moves = 0;
        comparisons = 0;
        int aux, j;
        this.comparisons++;
        for (int i = 1; i < numbers.length; i++) {
            aux = numbers[i];
            this.comparisons += 2;
            for (j = i; j > 0 && aux < numbers[j - 1]; j--) {
                this.moves++;
                numbers[j] = numbers[j - 1];
                this.comparisons += 2;
            }
            this.moves++;
            numbers[j] = aux;
            this.comparisons++;
        }
    }

    @Override
    public long getMoves(){
        return this.moves;
    }

    @Override
    public long getComparisons(){
        return this.comparisons;
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
