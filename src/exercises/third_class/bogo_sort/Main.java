package exercises.third_class.bogo_sort;

import files.FileHandler;
import sorting_methods.comparison_sorts.bogo_sort.BogoSort;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static exercises.second_class.Main.getArrayOfNumbersFromFile;

public class Main {
    public static void main(String[] args) {
        int[] numbers = getArrayOfNumbersFromFile("src/exercises/second_class/unsorted_data/dados5.txt");
        BogoSort.sort(numbers);
        System.out.println("Sorting dados5.txt: Bogo Sort");
        System.out.println("--------------------------------------------------");
        System.out.println(BogoSort.getInfo());
        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 5 numbers", "src/exercises/third_class/bogo_" +
                "sort/sorted_data/dados5.txt");
    }

    private static void recordInfoOntoFile(String sortedArray, String title, String filePath) {
        File newFile = new File(filePath);
        try {
            newFile.createNewFile(); //If the file exists or not, we don't care about it!
            FileHandler.writeOver(filePath, title + "\nTime-stamping: " + LocalDateTime.now() +"\n## Bogo Sort" +
                    "##\n" + BogoSort.getInfo() + "\n## Ordered data set ##: " + sortedArray);
        } catch(IOException | SecurityException e) {
            System.out.println("########### Something went bad! ############");
            System.exit(-1);
        }
    }
}
