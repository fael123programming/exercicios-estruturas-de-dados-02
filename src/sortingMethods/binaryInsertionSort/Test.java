package sortingMethods.binaryInsertionSort;

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
