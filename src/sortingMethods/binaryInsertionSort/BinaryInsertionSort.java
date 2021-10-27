package sortingMethods.binaryInsertionSort;

import searchTechniques.BinarySearch;
import java.util.LinkedList;

public class BinaryInsertionSort {

    public static void sort(LinkedList<Number> list) {
        int key;
        for (int i = 1; i < list.size(); i++) {
            key = list.get(i).getValue();
            if (list.get(i - 1).getValue() != key) list.add(BinarySearch.searchPossible(list, key, 0, i - 1), list.remove(i));
        }
    }

}
