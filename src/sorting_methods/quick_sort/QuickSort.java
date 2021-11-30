package sorting_methods.quick_sort;

public class QuickSort {
    private static long comparisons, moves;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    public static void enhancedSort(int[] numbers) {
        enhancedQuickSort(numbers, 0, numbers.length - 1);
        report = new StringBuilder();
        report.append("Quick Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        comparisons = 0;
        moves = 0;
    }

    public static String getReport(){
        if (report == null)
            return null;
        return report.toString();
    }

    private static void quickSort(int[] numbers, int startPos, int endPos) {
        if (startPos >= endPos)
            return;
        int pivotIndex = partition(numbers, startPos, endPos);
        quickSort(numbers, startPos, pivotIndex - 1);
        quickSort(numbers, pivotIndex + 1, endPos);
    }

    private static int partition(int[] numbers, int startPos, int endPos) {
        int pivot = numbers[endPos], pivotIndex = startPos;
        for (int i = startPos; i < endPos; i++) {
            if (numbers[i] <= pivot)
                swap(numbers, i, pivotIndex++);
            comparisons += 2; //At this for's header and at line 26.
        }
        comparisons++; //At line 25 that made that for to break.
        swap(numbers, pivotIndex, endPos);
        return pivotIndex;
    }

    private static void enhancedQuickSort(int [] numbers, int startPos, int endPos) {
        if (startPos >= endPos)
            return;
        comparisons++; //At line 36.
        int pivotIndex = randomizedPartition(numbers, startPos, endPos);
        enhancedQuickSort(numbers, startPos, pivotIndex - 1);
        enhancedQuickSort(numbers, pivotIndex + 1, endPos);
    }

    private static int randomizedPartition(int [] numbers, int startPos, int endPos) {
        int pivotIndex = random(startPos, endPos);
        swap(numbers, pivotIndex, endPos);
        return partition(numbers, startPos, endPos);
    }

    private static int random(int from, int to) {
        return (int) (from + (Math.random()  * (to + 1 - from)));
    }

    private static void swap(int[] numbers, int srcPos, int destPos) {
        int aux = numbers[srcPos];
        numbers[srcPos] = numbers[destPos];
        numbers[destPos] = aux;
        moves++;
    }
}
