package exercises.third_class.comb_sort.factor_one_dot_three;

import exercises.aux_class.AuxiliarClass;
import sorting_methods.comparison_sorts.comb_sort.CombSort;

public class Main {
    public static void main(String[] args) {
        final double FACTOR = 1.3;
        //Root path of the unsorted files.
        final String ROOT_PATH_UNSORTED_DATA = "src/exercises/unsorted_data/";
        //Root path to create the new files with sorted data.
        final String ROOT_PATH_SORTED_DATA = "src/exercises/third_class/comb_sort/factor_one_dot_three/sorted_data/";
        int[] numbers; //Array to contain all numbers gotten from the files with unsorted data.
        System.out.println("Comb Sort Factor 1.3 Ordination");
        System.out.println("----------------------------------------------------------------------");
//        File with 5 numbers.
        System.out.println("File with 5 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados5.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados5.txt", numbers, CombSort.getReport());
//    ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados100.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados100.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 1000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados1000.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados1000.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 10000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados10_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados10_mil.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 50000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados50_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados50_mil.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 100000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados100_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados100_mil.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------");
        System.out.println("File with 500000 numbers");
        numbers = AuxiliarClass.getNumbersInFile(ROOT_PATH_UNSORTED_DATA + "dados500_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getReport());
        AuxiliarClass.recordInfoIntoFile(ROOT_PATH_SORTED_DATA + "dados500_mil.txt", numbers, CombSort.getReport());
//     ----------------------------------------------------------------------------------------------------
    }
}
