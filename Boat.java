import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Boat {
    static Random random = new Random();

    public static int play (String boat, int position, String opp) throws IOException {
        Scanner presstoplay = new Scanner(System.in);

        System.out.printf("\nBOAT %s! IT'S YOUR TURN! \nPress ENTER to roll the dice: ", boat);
        presstoplay.nextLine();
        System.out.println("\n\n\n\n\n\n\n");

        int roll = RollTheDice();
        int initialPosition = position;
        position +=roll;
        if (position > 198) {
            position = 198;
        }
        System.out.printf("\nYou rolled a %d ! ", roll / 2);

        // still thinking how to represent names System.out.printf("Player %s, %s has won!!\n", boat, playername);

        if (River.getRiver(initialPosition).equals(boat)) {
            River.setRiver(initialPosition, " ");
        } else {
            River.setRiver(initialPosition, opp);
        }

        System.out.println();

        do {
            if (River.getRiver(position).equals("C")) {
                int forwardpush = Current.PushedForwardCurrents();
                position += forwardpush;
                if (position > 198) {
                    position = 198;
                }
                System.out.println("AND YOU HAVE BEEN PUSHED FORWARD BY A CURRENT (+" + forwardpush / 2 + ") !!");

            } else if (River.getRiver(position).equals("#")) {
                int backwardpush = Trap.PushedBackwardTraps();
                position -= backwardpush;
                if (position < 0) {
                    position = 0;
                }
                System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!");

            } else {}
        } while ( River.getRiver(position).equals("C") || River.getRiver(position).equals("#") );


        placement(position, boat, opp);
        River.printRiver();
        return position;
    }

    public static void placement(int position, String boat, String opp) {
        if (River.getRiver(position).equals(opp)) {
            River.setRiver(position, "½");
            System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " as well!!");

        } else if (River.getRiver(position).equals(" ")) {
            River.setRiver(position, boat);
            System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " !!\n");
        } else {
        }
    }

    public static int RollTheDice(){
        return ((random.nextInt(6) + 1) * 2);
    }
}
