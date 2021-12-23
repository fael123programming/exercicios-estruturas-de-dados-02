package sorting_methods.comparison_sorts.gnome_sort;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 7, 1, 6, 8, 3, 2};
        recursivePrint(numbers);
        GnomeSort.sort(numbers);
        recursivePrint(numbers);
    }

    private static void recursivePrint(int[] array) {
        display(array, 0);
    }

    private static void display(int[] array, int startPos) {
        if (startPos == 0)
            System.out.print("[");
        else if (startPos == array.length) {
            System.out.println("]");
            return; //Recursion base!
        }
        if (startPos < array.length - 1)
            System.out.print(array[startPos] + ", ");
        else
            System.out.print(array[startPos]);
        display(array, startPos + 1);
    }
}
