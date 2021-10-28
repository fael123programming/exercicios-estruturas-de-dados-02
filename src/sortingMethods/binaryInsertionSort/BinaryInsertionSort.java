package sortingMethods.binaryInsertionSort;

import searchTechniques.BinarySearch;

import java.util.LinkedList;

public class BinaryInsertionSort {
    public static void sort(LinkedList<Number> list) {
        int key;
        for (int i = 1; i < list.size(); i++) {
            key = list.get(i).getValue();
            if (list.get(i - 1).getValue() != key) {
                list.add(BinarySearch.searchPossible(list, key, 0, i - 1), list.remove(i));
            }
        }
    }

    public static void sort(int[] numbers) {
        int key, rightPos;
        for (int i = 1; i < numbers.length; i++) {
            key = numbers[i];
            if (numbers[i - 1] != key) {
                rightPos = BinarySearch.searchPossible(numbers, key, 0, i - 1);
                if (rightPos == i) continue;
                /*for (int j = i; j > rightPos; j--) {
                    numbers[j] = numbers[j - 1];
                }*/
                if (i - rightPos >= 0) System.arraycopy(numbers, rightPos, numbers, rightPos + 1, i - rightPos);
                numbers[rightPos] = key;
            }
        }
    }
}
