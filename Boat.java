import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Boat {
    static Random random = new Random();

    public static int play (String boat, int position, String opp) {
        Scanner presstoplay = new Scanner(System.in);
        System.out.printf("\nBOAT %s! IT'S YOUR TURN! \nPress ENTER to roll the dice: ", boat);
        presstoplay.nextLine();


        int roll = RollTheDice();
        position += roll;
        System.out.printf("\nYou rolled a %d ! ", roll / 2);

        if (position >= 198 || position >= 198) {
            River.setRiver(198, boat);
            River.setRiver(position - roll, " ");

            System.out.println();
            River.printRiver();

            // still thinking how to represent names System.out.printf("Player %s, %s has won!!\n", boat, playername);

            System.exit(0);

        } else {
            if (River.getRiver(position) == "C") {

                int forwardpush = Current.PushedForwardCurrents();
                position += forwardpush;
                
                if (collide(position, forwardpush, opp)) {
                	River.setRiver(position, boat);
                } else {
                	River.setRiver(position, "½");
                }
                
                System.out.println("AND YOU HAVE BEEN PUSHED FORWARD BY A CURRENT (+" + forwardpush / 2 + ") !!" + " Boat 1 is at box " + ((position / 2) + 1) + " !!");

            } else if (River.getRiver(position) == "#") {

                int backwardpush = Trap.PushedBackwardTraps();
                int tempposition = position;
                position -= backwardpush;
                
                if (collide(position, -backwardpush, opp)) { //idk if the - here works
                	River.setRiver(position, boat);
                	
                } else if ((position < 0) && (collide(tempposition, 0, opp))) {
                    if (collide(position, 0, opp)) {
                        River.setRiver(position, boat);
                    }
                }
                System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!" + " Boat 1 is at box 1 as well!!");

            } else if (collide(position, roll, opp)) {
            	River.setRiver(position, boat);
            	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " !!");
                
            } else {
            	River.setRiver(position - roll, " ");
            	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " as well!!");
            }
        System.out.println();
        River.printRiver();
        }
		return position;
    }


    public static boolean collide(int position, int roll, String opp) {
        if ((River.getRiver(position - roll)) == "½") {
        	River.setRiver(position - roll, opp);
            return true;
        } else if (River.getRiver(position) == opp){
        	River.setRiver(position, "½");
            return false;
        } else {
        	River.setRiver(position - roll, " ");
            return true;
        }
    }

    public static int RollTheDice(){
        return ((random.nextInt(6) + 1) * 2);
    }
}