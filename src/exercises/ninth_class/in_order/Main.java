package exercises.ninth_class.in_order;

import exercises.fourth_class.AuxiliarClass;
import time_measurement.Time;
import trees.binary_tree.classes.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); //Our binary tree to contain all numbers from the files...
        final String ROOT_PATH_UNSORTED_DATA = "src/exercises/unsorted_data/"; //Root path of the unsorted files.
        int[] numbers; //Array to contain all numbers gotten from the files.
        System.out.println("Printing the data in-order");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 5 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados5.txt");
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados100.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 1000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados1000.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 10000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados10_mil.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 50000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados50_mil.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados100_mil.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 500000 numbers");
        System.out.println("----------------------------------------------------------------------");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados500_mil.txt");
        tree.clean();
        tree.insert(numbers);
        Time.startCounting();
        tree.print();
        Time.finishCounting();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Time spent: " + Time.getTime());
        System.out.println("----------------------------------------------------------------------");
    }
}
