import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

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
    public static void SortContentInFile() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        ArrayList<String> lines = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader("TopScore.txt"));
            String currentLine = reader.readLine();
            while (currentLine != null){
                lines.add(currentLine);
                currentLine = reader.readLine();
            }
            Collections.sort(lines);
            writer = new BufferedWriter(new FileWriter("TopScore.txt"));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public void displayScore(){
        System.out.println("-------------------------------");
        System.out.println("| SCORE | PLAYER | DIFFICULTY |");
        System.out.println("-------------------------------");
        

    }

    public static void endGame(int number, String name, int score) throws IOException {
        System.out.printf("Player %d, %s has won with %d moves !!\n",number, name, score);
        writeTextToFile("TopScore.txt", Integer.toString(score) + " " +name + " " + River.getDifficulty() + "\n");
        SortContentInFile();
        System.exit(0);
    }


}