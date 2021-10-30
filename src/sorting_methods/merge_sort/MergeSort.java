package sorting_methods.merge_sort;

public class MergeSort {

    public static void sort(int[] numbers) {
        int numbersLen = numbers.length;
        if (numbersLen == 1) return;
        int midNumbers = numbersLen / 2;
        int[] left = new int[midNumbers];
        int[] right = new int[numbersLen - midNumbers];
        System.arraycopy(numbers, 0, left, 0, midNumbers);
        System.arraycopy(numbers, midNumbers, right, 0, numbersLen - midNumbers);
        sort(left);
        sort(right);
        merge(numbers, left, right);
    }

    private static void merge(int[] numbers, int[] left, int[] right) {
        int leftAux = 0, rightAux = 0, numbersAux = 0;
        while (leftAux < left.length && rightAux < right.length) {
            if (left[leftAux] <= right[rightAux]) numbers[numbersAux] = left[leftAux++];
            else numbers[numbersAux] = right[rightAux++];
            numbersAux++;
        }
        while (leftAux < left.length) {
            numbers[numbersAux++] = left[leftAux++];
        }
        while (rightAux < right.length) {
            numbers[numbersAux++] = right[rightAux++];
        }
    }
}
