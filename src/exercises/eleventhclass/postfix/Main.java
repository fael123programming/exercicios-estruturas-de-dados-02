package exercises.eleventhclass.postfix;

import exercises.fourth_class.AuxiliarClass;
import time_measurement.Time;
import trees.binary_tree.balanced.redblack.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>(); //Our binary tree to contain all numbers from the files...
        final String ROOT_PATH_UNSORTED_DATA = "src/exercises/unsorted_data/"; //Root path of the unsorted files.
        Integer[] numbers; //Array to contain all numbers gotten from the files.
        System.out.println("Red-Black Tree: Balanced Binary Search Tree");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Printing the data in postfix way");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 5 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados5.txt");
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados100.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 1000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados1000.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 10000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados10_mil.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 50000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados50_mil.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados100_mil.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 500000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile2(ROOT_PATH_UNSORTED_DATA + "dados500_mil.txt");
        redBlackTree.clean();
        redBlackTree.insert(numbers);
        Time.startCounting();
        redBlackTree.print(RedBlackTree.POSTFIX);
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
    }
}
