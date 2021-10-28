package sortingMethods.binaryInsertionSort;

import searchTechniques.BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Number> numbers = new LinkedList<>();
        numbers.add(new Number(1234, 'A'));
        numbers.add(new Number(1234, 'B'));
        numbers.add(new Number(1234, 'C'));
        numbers.add(new Number(-100, 'D'));
        numbers.add(new Number(1234, 'E'));
        numbers.add(new Number(450, 'F'));
        numbers.add(new Number(1234, 'G'));
        numbers.add(new Number(5000, 'H'));
        numbers.add(new Number(3450, 'I'));
        System.out.print("Before sorting: ");
        Test.print(numbers);
        BinaryInsertionSort.sort(numbers);
        System.out.print("After sorting: ");
        Test.print(numbers);
        System.out.println("------------------------------------------------------------------------------");
        int[] numbersArray = {1234, 1234, 1234, -100, 1234, 450, 1234, 5000, 3450};
        System.out.println("Before sorting: " + Arrays.toString(numbersArray));
        BinaryInsertionSort.sort(numbersArray);
        System.out.println("After sorting: " + Arrays.toString(numbersArray));
        System.out.println("------------------------------------------------------------------------------");
        int []sortedNumbers = {100, 244, 3000, 4345, 50000, 51234, 90000, 1100000};
        BinaryInsertionSort.sort(sortedNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
        System.out.println("------------------------------------------------------------------------------");
        sortedNumbers = new int[]{10, 9 , 8, 7, 6, 5, 4, 3, 2, 1};
        BinaryInsertionSort.sort(sortedNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

    }

    public static void print(LinkedList<Number> numbers) {
        System.out.print("{");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i).getIdentity() + ":" + numbers.get(i).getValue());
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
