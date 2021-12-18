package exercises.third_class.comb_sort.factor_one_dot_three;

import files.FileHandler;
import sorting_methods.comparison_sorts.comb_sort.CombSort;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static exercises.second_class.Main.getArrayOfNumbersFromFile;

public class Main {
    public static void main(String[] args) {
        final double FACTOR = 1.3D;
        final String BASE_ROOT_TO_WRITE = "src/exercises/third_class/comb_sort/factor_one_dot_three/sorted_data/";
        final String BASE_ROOT_TO_READ = "src/exercises/second_class/unsorted_data/";
        int[] numbers; //Used to contain our numbers gotten from the files.
        //-----------------------------------------------------
        message("Sorting dados5.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados5.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 5 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados5.txt");
        //-----------------------------------------------------
        message("Sorting dados100.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados100.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 100 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados100.txt");
        //-----------------------------------------------------
        message("Sorting dados1000.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados1000.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 1000 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados1000.txt");
        //-----------------------------------------------------
        message("Sorting dados10_mil.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados10_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 10000 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados10_mil.txt");
        //-----------------------------------------------------
        message("Sorting dados50_mil.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados50_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 50000 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados50_mil.txt");
        //-----------------------------------------------------
        message("Sorting dados100_mil.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados100_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 100000 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados100_mil.txt");
        //-----------------------------------------------------
        message("Sorting dados500_mil.txt: Comb Sort with factor " + FACTOR);
        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados500_mil.txt");
        CombSort.sort(numbers, FACTOR);
        System.out.println(CombSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 500000 numbers: factor " + FACTOR, BASE_ROOT_TO_WRITE + "dados500_mil.txt");
    }

    private static void message(String text) {
        System.out.println("--------------------------------------------------");
        System.out.println(text);
        System.out.println("--------------------------------------------------");
    }

    private static void recordInfoOntoFile(String sortedArray, String title, String filePath) {
        File newFile = new File(filePath);
        try {
            newFile.createNewFile(); //If the file exists or not, we don't care about it!
            FileHandler.writeOver(filePath, title + "\nTime-stamping: " + LocalDateTime.now() +"\n## Comb so" +
                    "rt ##\n" + CombSort.getInfo() + "\n## Ordered data set ##: " + sortedArray);
        }catch(IOException | SecurityException e) {
            System.out.println("########### Something went bad! ############");
            System.exit(-1);
        }
    }
}
