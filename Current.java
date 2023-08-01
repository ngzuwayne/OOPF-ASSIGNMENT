import java.util.*;

public class Current {
    private static int currentno;
    private static String difficulty;
    private static Random random = new Random();
    
    public static void PrintCurrents() {
        difficulty = River.getDifficulty();
        if (difficulty == "HARD"){
            currentno = random.nextInt(3, 7);
        } else if (difficulty == "MEDIUM"){
            currentno = random.nextInt(7, 10);
        } else if (difficulty == "EASY"){
            currentno = random.nextInt(10, 13);
        }

        for (int i = 0; i < currentno; i++) {
            int b = WhereCurrents();
            River.setRiver(b, "C");
        }
    }
    
    public static int WhereCurrents() {
        int b = 1;
        while ((b % 2) != 0) {
            b = random.nextInt(10, 181);
        }
        return b;
    }
    
    public static int PushedForwardCurrents(){
        int forwardpush = (random.nextInt(9) + 5) * 2;
        return forwardpush;
    }
}