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

    	if (River.getRiver(initialPosition) == boat) {
    		River.setRiver(initialPosition, " ");
    	} else {
    		River.setRiver(initialPosition, opp);
    	}
    	
    	System.out.println();

        // still thinking how to represent names System.out.printf("Player %s, %s has won!!\n", boat, playername);

    	do {
        	if (River.getRiver(position) == "C") {
                int forwardpush = Current.PushedForwardCurrents();
                position += forwardpush;
                if (position > 198) {
        			position = 198;
        		}           
                System.out.println("AND YOU HAVE BEEN PUSHED FORWARD BY A CURRENT (+" + forwardpush / 2 + ") !!");
                
        	} else if (River.getRiver(position) == "#") {
        		int backwardpush = Trap.PushedBackwardTraps();
        		position -= backwardpush;
        		if (position < 0) {
        			position = 0;
        		}
        		System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!");
        		
        	} else {} 
    	} while ( River.getRiver(position) == "C" || River.getRiver(position) == "#" );
    	
    	if (position > 198) {
    		position = 198;
            if (boat == "1"){
                System.out.println("Player 1 " + Player.getName() + " has won with " + (Player.getScore() + 1) + " moves !!");
                Score.writeTextToFile("scores.txt", Player.getName() + " " + Integer.toString(Player.getScore() + 1) + "\n");
            } else if (boat == "2") {
                System.out.println("Player 2 " + Player.getName() + " has won with " + (Player.getScore()) + " moves !!");
                Score.writeTextToFile("scores.txt", Player.getName() + " " + Integer.toString(Player.getScore()) + "\n");
            }

            System.exit(0);
    	}
    	placement(position, boat, opp);
        River.printRiver();
        return position;
    }

    public static void placement(int position, String boat, String opp) {
        if (River.getRiver(position) == opp) {
        	River.setRiver(position, "½");
        	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " as well!!");
        	
        } else if (River.getRiver(position) == " ") {
        	River.setRiver(position, boat);
        	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " !!\n");
        } else {
        }
    }

    public static int RollTheDice(){
        return ((random.nextInt(6) + 1) * 2);
    }
}