package sorting_methods.bucket_sort.sorting_algorithms;

public interface SortingAlgorithm {
    void sort(int[] numbers);
    long getMoves();
    long getComparisons();
    String getName();
}
