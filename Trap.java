import java.util.Random;

public class Trap {
    private static Random random = new Random();
    
    public static void PrintTraps() {
        String difficulty = River.setDifficulty();
        int trapno = random.nextInt(7, 10);
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