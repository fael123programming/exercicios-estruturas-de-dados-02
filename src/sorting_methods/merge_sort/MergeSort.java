package sorting_methods.merge_sort;

public class MergeSort {
    private static long comparisons, moves;
    private static StringBuilder report;

    public static void sort(int[] numbers) {
        mergeSort(numbers);
        report = new StringBuilder();
        report.append("Merge Sort\n");
        report.append("Size of the input: ").append(numbers.length).append("\n");
        report.append("Comparisons: ").append(comparisons).append("\n");
        report.append("Moves: ").append(moves).append("\n");
        comparisons = 0;
        moves = 0;
    }

    public String getReport(){
        if(report == null)
            return null;
        return report.toString();
    }

    private static void mergeSort(int[] numbers) {
        int numbersLen = numbers.length;
        if (numbersLen == 1) return; //End or base condition of the recursion.
        comparisons++; //At line above.
        int midNumbers = numbersLen / 2;
        int[] left = new int[midNumbers];
        int[] right = new int[numbersLen - midNumbers];
        System.arraycopy(numbers, 0, left, 0, midNumbers);
        System.arraycopy(numbers, midNumbers, right, 0, numbersLen - midNumbers);
        moves += numbersLen; //Both lines above.
        mergeSort(left); //Recursive call: sort the left side before continuing and then come back here again.
        mergeSort(right); //Recursive call: sort the right side before continuing and then come back here again.
        merge(numbers, left, right); //Now merge all sorted elements in left and right into numbers.
    }

    private static void merge(int[] numbers, int[] left, int[] right) {
        int leftAux = 0, rightAux = 0, numbersAux = 0;
        while (leftAux < left.length && rightAux < right.length) {
            comparisons += 2; //At the line above.
            if (left[leftAux] <= right[rightAux])
                numbers[numbersAux] = left[leftAux++];
            else
                numbers[numbersAux] = right[rightAux++];
            numbersAux++;
            comparisons++; //At line 43.
            moves++; //At line 44 or 46 depending on the evaluation of the condition at line 43.
        }
        comparisons += 2; //At line 41 that made that while to break.
        //Only one of these loops will be executed to empty
        //the array with remaining elements yet.
        while (leftAux < left.length) {
            numbers[numbersAux++] = left[leftAux++];
            comparisons++; //At line 54.
            moves++; //At line 55.
        }
        comparisons++; //At line 54 that made that while to break.
        while (rightAux < right.length) {
            numbers[numbersAux++] = right[rightAux++];
            comparisons++; //At line 60.
            moves++; //At line 61.
        }
        comparisons++; //At line 60 that made that while to break.
    }

    public static void sort2(int[] numbers) {
//        This method works on the same array but separating it in different regions
//        of ordination. Indeed, it creates a new array to contain data temporarily.
        auxSort2(numbers, 0, numbers.length - 1);
    }

    private static void auxSort2(int[] numbers, int start, int end) {
        if (start >= end)
            return; //Recursion base: it is responsible for breaking the recursion.
        int mid = (start + end) / 2; //Getting the position of the element at the middle of numbers.
        auxSort2(numbers, start, mid); //Ordering each side.
        auxSort2(numbers, mid + 1, end);
        merge2(numbers, start, mid, end); //Merging each side's data into a new bigger sorted region.
    }

    private static void merge2(int[] numbers, int start, int mid, int end) {
        int size = end - start + 1, p1 = start, p2 = mid + 1;
        int[] aux = new int[size];
        for(int i = 0; i < size; i++) {
            if(p1 <= mid && p2 <= end) {
                if (numbers[p1] <= numbers[p2])
                    aux[i] = numbers[p1++];
                else
                    aux[i] = numbers[p2++];
            } else {
                if (p1 <= mid)
                    aux[i] = numbers[p1++];
                else
                    aux[i] = numbers[p2++];
            }
        }
        for (int j = 0, k = start; j < size; j++, k++)
            numbers[k] = aux[j];
        aux = null; //Maybe GC gets here more quickly...
    }
}
