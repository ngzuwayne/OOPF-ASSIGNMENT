import java.util.Random;
public class Trap {
    static Random random = new Random();
    static int[] EvenNumbers = {10, 12, 14, 16, 18};
    public static void PrintTraps() {
        int trapno = random.nextInt(7, 10);
        for (int i = 0; i < trapno; i++) {
            int b = WhereTraps();
            Boat.array[1][b] = "#";
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
        int backwardpush = EvenNumbers[random.nextInt(EvenNumbers.length)];
        return backwardpush;
    }
}