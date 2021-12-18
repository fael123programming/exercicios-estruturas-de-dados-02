package sorting_methods.comparison_sorts.heap_sort;

import time_measurement.Time;

import static sorting_methods.comparison_sorts.quick_sort.QuickSort.swap;

public class HeapSort {
    private static long moves, comparisons;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        if (numbers == null)
            return;
        Time.startCounting();
        buildMaxHeap(numbers); //Creates a max-heap.
        for (int i = numbers.length - 1; i > 0; i--) { //'i' will vary from the last position of the array to the second.
            comparisons++;
            swap(numbers, 0, i); //Swaps the root (0) and last (i) element.
            moves++;
            heapifyMax(numbers, 0, i); //Creates max-heap on reduced array.
//            'i' will contain the current size of the heap.
        }
        Time.finishCounting();
        comparisons++;
        report = new StringBuilder();
        report.append("Heap Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        report.append("Time (HH:MM:SS:mm): ").append(Time.getTime());
        comparisons = 0;
        moves = 0;
    }

    private static void buildMaxHeap(int[] numbers) {
//        (i - 1) / 2
//        2 * i + 1
//        2 * i + 2
        for (int i = numbers.length / 2 - 1; i >= 0; i--) {
            comparisons++;
            heapifyMax(numbers, i, numbers.length); //Creates a max-heap.
        }
        comparisons++;
//        In a max-heap, every parent node is greater than or equal its children.
//        The array 'numbers' is considered as a binary tree: the first position is
//        the root and each parent has at most two children.
    }

    private static void heapifyMax(int[] numbers, int current, int size) {
        int largest = current, leftChild = 2 * current + 1, rightChild = 2 * current + 2;
        comparisons++;
        if (leftChild < size && numbers[leftChild] > numbers[largest]) {
            largest = leftChild;
        }
        comparisons++;
        if (rightChild < size && numbers[rightChild] > numbers[largest]) {
            largest = rightChild;
        }
        comparisons++;
        if (largest == current)
            return;
        //Recursion base: if a parent element has no children greater than itself, the recursion must terminate.
        swap(numbers, current, largest); //Otherwise, swap child (largest) and parent (current).
        moves++;
        heapifyMax(numbers, largest, size); //Continue rating the children of largest.
    }

    public static String getReport() {
        if (report == null)
            return null;
        return report.toString();
    }
}
