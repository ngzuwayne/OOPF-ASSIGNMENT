import java.util.*;

public class Current {
    private static int currentno;
    private static String difficulty;
    private static Random random = new Random();
    
    public static void PrintCurrents() {
        difficulty = River.getDifficulty();
        if (difficulty == "Hard"){
            currentno = random.nextInt(3, 6);
        } else if (difficulty == "Medium"){
            currentno = random.nextInt(7, 10);
        } else if (difficulty == "Easy"){
            currentno = random.nextInt(11, 14);
        }
        int a = currentno;
        for (int i = 0; i < a; i++) {
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