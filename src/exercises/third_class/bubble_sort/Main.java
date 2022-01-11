package exercises.third_class.bubble_sort;

import files.FileHandler;
import sorting_methods.comparison_sorts.bubble_sort.BubbleSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        final String BASE_ROOT_TO_WRITE = "src/exercises/third_class/bubble_sort/sorted_data/";
//        final String BASE_ROOT_TO_READ = "src/exercises/second_class/unsorted_data/";
//        int[] numbers; //Used to contain our numbers gotten from the files.
//        //-----------------------------------------------------
//        message("Sorting dados5.txt: Bubble Sort");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados5.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 5 numbers", BASE_ROOT_TO_WRITE + "dados5.txt");
//        //-----------------------------------------------------
//        message("Sorting dados100.txt: Bubble Sort");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados100.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 100 numbers", BASE_ROOT_TO_WRITE + "dados100.txt");
//        //-----------------------------------------------------
//        message("Sorting dados1000.txt: Bubble Sort");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados1000.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 1000 numbers", BASE_ROOT_TO_WRITE + "dados1000.txt");
//        //-----------------------------------------------------
//        message("Sorting dados10_mil.txt");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados10_mil.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 10000 numbers", BASE_ROOT_TO_WRITE + "dados10_mil.txt");
//        //-----------------------------------------------------
//        message("Sorting dados50_mil.txt");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados50_mil.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 50000 numbers", BASE_ROOT_TO_WRITE + "dados50_mil.txt");
//        //-----------------------------------------------------
//        message("Sorting dados100_mil.txt");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados100_mil.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 100000 numbers", BASE_ROOT_TO_WRITE + "dados100_mil.txt");
//        //-----------------------------------------------------
//        message("Sorting dados500_mil.txt");
//        numbers = getArrayOfNumbersFromFile(BASE_ROOT_TO_READ + "dados500_mil.txt");
//        BubbleSort.sort(numbers);
//        System.out.println(BubbleSort.getInfo());
//        recordInfoOntoFile(Arrays.toString(numbers), "Sorting 500000 numbers", BASE_ROOT_TO_WRITE + "dados500_mil.txt");
//    }
//
//    private static void message(String text) {
//        System.out.println("--------------------------------------------------");
//        System.out.println(text);
//        System.out.println("--------------------------------------------------");
//    }
//
//    private static void recordInfoOntoFile(String sortedArray, String title, String filePath) {
//        File newFile = new File(filePath);
//        try {
//            newFile.createNewFile(); //If the file exists or not, we don't care about it!
//            FileHandler.writeOver(filePath, title + "\nTime-stamping: " + LocalDateTime.now() +"\n## Bubble so" +
//                    "rt ##\n" + BubbleSort.getInfo() + "\n## Ordered data set ##: " + sortedArray);
//        }catch(IOException | SecurityException e) {
//            System.out.println("########### Something went bad! ############");
//            System.exit(-1);
//        }
    }
}
