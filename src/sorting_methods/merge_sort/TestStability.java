package sorting_methods.merge_sort;

import java.util.Arrays;

public class TestStability {
    public static void main(String[] args) {
        Number[] numbers = { new Number('I', 11), new Number('A', 1), new Number('H', 10),
        new Number('B', 2), new Number('G', 9), new Number('D', 3), new Number('F', 8),
        new Number('E', 4), new Number('C', 2), new Number('J', 11)};
        System.out.println("Testing stability");
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After that get done: " + Arrays.toString(numbers));
    }

    private static void sort(Number[] arrayOfNumbers) {
        int size = arrayOfNumbers.length;
        if (size == 1) return;
        int mid = size / 2;
        Number[] left = new Number[mid];
        Number[] right = new Number[size - mid];
        for(int i = 0; i < mid; i++) //Coping values from arrayOfNumbers to left and right.
            left[i] = arrayOfNumbers[i];
        for(int i = 0; i < size - mid; i++)
            right[i] = arrayOfNumbers[mid + i];
        sort(left);
        sort(right);
        merge(arrayOfNumbers, left, right);
    }

    private static void merge(Number[] destiny, Number[] left, Number[] right) {
        int leftAux = 0, rightAux = 0, destinyAux = 0;
        while (leftAux < left.length && rightAux < right.length) {
                if (left[leftAux].value <= right[rightAux].value)
                    destiny[destinyAux] = left[leftAux++];
                else
                    destiny[destinyAux] = right[rightAux++];
            destinyAux++;
        }
        while (leftAux < left.length)
            destiny[destinyAux++] = left[leftAux++];
        while (rightAux < right.length)
            destiny[destinyAux++] = right[rightAux++];
    }

    private static class Number {
        private final char symbol;
        private final int value;

        public Number(char symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }

        @Override
        public String toString() {
            return "symbol: " + symbol + " value: " + value;
        }
    }
}
