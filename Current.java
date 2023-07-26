import java.util.*;
public class Current {
    static Random random = new Random();
    static int[] EvenNumbers = {10, 12, 14, 16, 18};
    public static void PrintCurrents() {
        int currentno = random.nextInt(7, 10);
        for (int i = 0; i < currentno; i++) {
            int b = WhereCurrents();
            Boat.array[1][b] = "C";
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
        int forwardpush = EvenNumbers[random.nextInt(EvenNumbers.length)];
        return forwardpush;
    }
}