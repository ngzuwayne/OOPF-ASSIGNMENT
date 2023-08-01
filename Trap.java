import java.util.Random;

public class Trap {
    private static Random random = new Random();
    private static int trapno;
    private static String difficulty;
    
    public static void PrintTraps() {
        difficulty = River.getDifficulty(difficulty);
        if (difficulty == "HARD"){
            trapno = random.nextInt(10, 13);
        } else if (difficulty == "MEDIUM"){
            trapno = random.nextInt(7, 10);
        } else if (difficulty == "EASY"){
            trapno = random.nextInt(4, 7);
        }
        for (int i = 0; i < trapno; i++) {
            int b = WhereTraps();
            River.setRiver(b, "#");
        }
    }
    
    public static int WhereTraps() {
        int b = 1;
        while ((b % 2) != 0) {
            b = random.nextInt(10, 199);
        }
        return b;
    }
    
    public static int PushedBackwardTraps(){
        int backwardpush = (random.nextInt(9) + 5) * 2;
        return backwardpush;
    }
}