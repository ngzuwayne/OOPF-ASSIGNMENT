import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Score {

    public static void createFileIfNotExists(String filename) throws IOException {
        // Create a file if it does not exist.
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void writeTextToFile(String filename, String text) throws IOException {
        // Write text to the file.
        FileWriter writer = new FileWriter(filename, true);
        writer.write(text);
        writer.close();
    }




}