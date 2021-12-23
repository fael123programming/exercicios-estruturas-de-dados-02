package exercises.sixth_class.radix_sort.msd;

import exercises.aux_class.AuxiliarClass;
import sorting_methods.key_based_sorts.radix_sort.RadixSort;

public class Main {
    public static void main(String[] args) {
        final String rootPathUnsortedFiles = "C:\\Users\\rafae\\OneDrive\\Documents\\prg\\java\\" +
                "exercicios-estruturas-de-dados-02\\src\\exercises\\second_class\\unsorted_data\\";
        final String rootPathSortedFiles = "C:\\Users\\rafae\\OneDrive\\Documents\\prg\\java\\" +
                "exercicios-estruturas-de-dados-02\\src\\exercises\\sixth_class\\radix_sort\\msd\\sorted_data\\";
        int[] numbers; //Array to contain all numbers gotten from the files with unsorted data.
        System.out.println("M.S.D Radix Sort");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 5 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados5.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados5.txt", numbers, RadixSort.getReport());
        //    ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados100.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados100.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 1000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados1000.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados1000.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 10000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados10_mil.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados10_mil.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 50000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados50_mil.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados50_mil.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados100_mil.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados100_mil.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 500000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(rootPathUnsortedFiles + "dados500_mil.txt");
        RadixSort.MSDSort(numbers);
        System.out.println(RadixSort.getReport());
        AuxiliarClass.recordInfoIntoFile(rootPathSortedFiles + "dados500_mil.txt", numbers, RadixSort.getReport());
//     ----------------------------------------------------------------------------------------------------
    }
}
