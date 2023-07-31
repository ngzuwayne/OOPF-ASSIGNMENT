import java.util.*;

public class Current {
    private static Random random = new Random();
    
    public static void PrintCurrents() {
        int currentno = random.nextInt(7, 10);
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