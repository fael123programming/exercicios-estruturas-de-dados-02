package exercises.second_class;

import files.FileHandler;
import sortingMethods.insertionSort.InsertionSort;
import sortingMethods.selectionSort.SelectionSort;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    private static final InsertionSort INSORT = new InsertionSort();
    private static final SelectionSort SELSORT = new SelectionSort();

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------");
        int[] numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados5.txt");
        System.out.println("Firstly, ordering 5 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion Sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados5.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection Sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 5 numbers", "src/exercises/second_class/sorted_data/dados5.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados100.txt");
        System.out.println("After, ordering 100 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados100.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 100 numbers", "src/exercises/second_class/sorted_data/dados100.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados1000.txt");
        System.out.println("Now, let's sort 1000 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados1000.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 1000 numbers", "src/exercises/second_class/sorted_data/dados1000.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados10_mil.txt");
        System.out.println("Sorting 10000 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados10_mil.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 10000 numbers", "src/exercises/second_class/sorted_data/dados10_mil.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados50_mil.txt");
        System.out.println("Sorting 50000 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados50_mil.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 50000 numbers", "src/exercises/second_class/sorted_data/dados50_mil.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados100_mil.txt");
        System.out.println("Sorting 100000 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados100_mil.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 100000 numbers", "src/exercises/second_class/sorted_data/dados100_mil.txt");
        //-------------------------------------------------------------------------------------------------------
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados500_mil.txt");
        System.out.println("Sorting 500000 numbers...");
        INSORT.order(numbersToOrder);
        System.out.println("Insertion sort");
        System.out.println(INSORT.getInfo());
        System.out.println("###########################################################");
        numbersToOrder = Main.getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados500_mil.txt");
        SELSORT.order(numbersToOrder);
        System.out.println("Selection sort");
        System.out.println(SELSORT.getInfo());
        System.out.println("-----------------------------------------------------------");
        Main.recordInfoOntoFile(Arrays.toString(numbersToOrder),"Ordering 500000 numbers", "src/exercises/second_class/sorted_data/dados500_mil.txt");
    }

    public static int[] getArrayOfNumbersFromFile(String filePath) {
        String[] strNumbers = FileHandler.readFile(filePath).replace("[", "").replace("]", "").split(",");
        int[] numbers = new int[strNumbers.length];
        for (int counter = 0; counter < strNumbers.length; counter++) {
            numbers[counter] = Integer.parseInt(strNumbers[counter].trim());
        }
        return numbers;
    }

    public static void recordInfoOntoFile(String sortedNumbersInString, String title, String filePath) {
        File newFile = new File(filePath);
        try {
            newFile.createNewFile(); //If the file exists or not, we don't care about it!
            FileHandler.writeOver(filePath, title + "\nTime-stamping: " + LocalDateTime.now() +"\n## Insertion sort ##\n" + INSORT.getInfo() + "\n\n## Selection sort ##\n" + SELSORT.getInfo() + "\n\n## Ordered data set ##: " + sortedNumbersInString);
        }catch(IOException | SecurityException e) {
            System.out.println("########### Something went bad! ############");
            System.exit(-1);
        }
    }
}
