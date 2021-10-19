package files;

import java.io.*;
import java.util.*;

public class FileHandler {

    private FileHandler() {
    }

    public static void writeOver(String path, String information) throws IllegalArgumentException, FileNotFoundException, IOException {
        if (path == null || information == null) throw new IllegalArgumentException("Invalid Arguments!");
        FileOutputStream output = new FileOutputStream(path); //Can cause a FileNotFoundException to be thrown!
        OutputStreamWriter writer = new OutputStreamWriter(output);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write(information); //Can cause an IOException to be thrown!
        buffer.close(); //Can cause an IOException to be thrown!
    }

    public static boolean appendTo(String path, String information) {
        if (path == null || information == null) return false;
        try (FileOutputStream output = new FileOutputStream(path, true)) {
            OutputStreamWriter writer = new OutputStreamWriter(output);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.newLine();
            buffer.write(information);
            buffer.close();
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public static String readFile(String path) {
        try (Scanner fileScan = new Scanner(new File(path))) {
            StringBuilder builder = new StringBuilder();
            while (fileScan.hasNextLine()) {
                builder.append(fileScan.nextLine()).append("\n");
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static String getLine(String path, int number) throws IllegalArgumentException, FileNotFoundException {
        if (path == null || number < 0) throw new IllegalArgumentException("Invalid Argument!");
        Scanner fileScan = new Scanner(new File(path));
        while (number > 0) {
            fileScan.nextLine();
            number--;
        }
        return fileScan.nextLine();
    }
}
