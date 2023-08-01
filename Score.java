import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Score {
    public static File createFile() {
        File file = new File("scores.txt");
        return file;
    }

    public static void writeTextToFile(String text) {
        File file = createFile();
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}