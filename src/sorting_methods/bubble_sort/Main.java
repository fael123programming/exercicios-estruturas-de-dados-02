package sorting_methods.bubble_sort;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 500000;
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = SIZE - i;
        }
        BubbleSort.sort(numbers);
        System.out.println(BubbleSort.getReport());
    }
}
