package exercises.aux_class;

import java.io.*;
import java.util.Arrays;

public class AuxiliarClass {
    /**
     * This method tries to access the file specified by filePath and get
     * all numbers in it into an array of numbers. Then, if all things
     * went as expected (the file exists and there are numbers record in it)
     * it returns this array.
     *
     * @param filePath the path of the file to be accessed
     * @return an array comprised of all numbers found in the file at filePath
     */
    public static int[] getNumbersInFile(String filePath) {
        try (InputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(fileInputStream);
             BufferedReader buffer = new BufferedReader(reader)
        ) {
            StringBuilder fileData = new StringBuilder();
            buffer.lines().forEach(fileData::append); //method reference.
            fileData.deleteCharAt(0).deleteCharAt(fileData.length() - 1); //Taking '[' and ']' out.
            String[] numbersStr = fileData.toString().split(", ");
            int[] numbers = new int[numbersStr.length];
            for(int i = 0; i < numbers.length; i++)
                numbers[i] = Integer.parseInt(numbersStr[i]);
            return numbers;
        } catch (FileNotFoundException fnfe) {
            System.out.println("A file at " + filePath + " does not exist");
            System.out.println("Check it out");
        } catch (IOException ioe) {
            System.out.println("An IOException was thrown when trying to access the file at " + filePath);
        }
        return new int[]{}; //Unreachable statement.
    }

    /**
     * This method tries to access the file specified by filePath and record into it
     * the string representation of the array numbers headed by the contents of
     * information. Note that if the file does not exist, this method tries to
     * create a new one at filePath.
     *
     * @param filePath    the path of the file to receive the new data
     * @param numbers     the array of numbers to be written into the file
     * @param information additional information about numbers
     */
    public static void recordInfoIntoFile(String filePath, int[] numbers, String information) {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch(IOException ioe) {
            System.out.println("An IOException was thrown when trying to create a new file at " + filePath);
        }
        try (OutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            BufferedWriter buffer = new BufferedWriter(writer)) {
            buffer.write(information + "\n"); //Header information about the sorting.
            buffer.write("Sorted array: \n");
            buffer.write(Arrays.toString(numbers)); //The sorted array.
        } catch(FileNotFoundException fnfe) {
            System.out.println("A file at " + filePath + " does not exist");
            System.out.println("Check it out");
        } catch(IOException ioe) {
            System.out.println("An IOException was thrown when trying to access the file at " + filePath);
        }
    }
}
