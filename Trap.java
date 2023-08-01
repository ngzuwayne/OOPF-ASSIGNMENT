import java.util.Random;

public class Trap {
    private static Random random = new Random();
    private static int trapno;
    private static String difficulty;
    private static int backwardpush;
    
    public static void PrintTraps() {
        difficulty = River.getDifficulty();
        if (difficulty == "Hard"){
            trapno = random.nextInt(11, 14);
        } else if (difficulty == "Medium"){
            trapno = random.nextInt(7, 10);
        } else if (difficulty == "Easy"){
            trapno = random.nextInt(3, 6);
        }
        int a = trapno;
        for (int i = 0; i < a; i++) {
            int b = WhereTraps();
            River.setRiver(b, "#");
        }
    }
    
    public static int WhereTraps() {
        int b = 1;
        while ((b % 2) != 0) {
            b = random.nextInt(10, 181);
        }
        return b;
    }
    
    public static int PushedBackwardTraps(){
        difficulty = River.getDifficulty();
        if (difficulty == "Hard"){
            backwardpush = (random.nextInt(10,15) * 2);
        } else if (difficulty == "Medium"){
            backwardpush = (random.nextInt(5,10) * 2);
        } else if (difficulty == "Easy"){
            backwardpush = (random.nextInt(0,5) * 2);
        }
        return backwardpush;
    }
}