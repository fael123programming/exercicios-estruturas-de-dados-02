package sorting_methods.merge_sort;

public class MergeSort {

    public static void sort(int[] numbers) {
        int numbersLen = numbers.length;
        if (numbersLen == 1) return; //End or base condition of the recursion.
        int midNumbers = numbersLen / 2;
        int[] left = new int[midNumbers];
        int[] right = new int[numbersLen - midNumbers];
        System.arraycopy(numbers, 0, left, 0, midNumbers);
        System.arraycopy(numbers, midNumbers, right, 0, numbersLen - midNumbers);
        sort(left); //Recursive call: sort the left side before continuing and then come back here again.
        sort(right); //Recursive call: sort the right side before continuing and then come back here again.
        merge(numbers, left, right); //Now merge all sorted elements in left and right into numbers.
    }

    private static void merge(int[] numbers, int[] left, int[] right) {
        int leftAux = 0, rightAux = 0, numbersAux = 0;
        while (leftAux < left.length && rightAux < right.length) {
            if (left[leftAux] <= right[rightAux])
                numbers[numbersAux] = left[leftAux++];
            else
                numbers[numbersAux] = right[rightAux++];
            numbersAux++;
        }
        //Only one of these loops will be executed to empty
        //the array with remaining elements yet.
        while (leftAux < left.length)
            numbers[numbersAux++] = left[leftAux++];
        while (rightAux < right.length)
            numbers[numbersAux++] = right[rightAux++];
    }
}
