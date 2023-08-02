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


        int roll = RollTheDice();
        int initialPosition = position;
        position +=roll;
        System.out.printf("\nYou rolled a %d ! ", roll / 2);
        
        //do (River.getRiver(position)== "C" || River.getRiver(position)== "#") {}
        
        if (position >= 198) {
            River.setRiver(198, boat);
            River.setRiver(position - roll, " ");

            System.out.println();
            River.printRiver();

            // still thinking how to represent names System.out.printf("Player %s, %s has won!!\n", boat, playername);
            if (boat == "1"){
                System.out.println("Player 1 " + Player.getName() + " has won with " + (Player.getScore() + 1) + " moves !!");
                Score.writeTextToFile("scores.txt", Player.getName() + " " + Integer.toString(Player.getScore() + 1) + "\n");
            } else if (boat == "2") {
                System.out.println("Player 2 " + Player.getName() + " has won with " + (Player.getScore()) + " moves !!");
                Score.writeTextToFile("scores.txt", Player.getName() + " " + Integer.toString(Player.getScore()) + "\n");
            }

            System.exit(0);

        } else {
        	if (River.getRiver(initialPosition) == boat) {
        		River.setRiver(initialPosition, " ");
        	} else {
        		River.setRiver(initialPosition, opp);
        	}
        	
        	if (River.getRiver(position) == "C") {
        		River.setRiver(position, " ");
                int forwardpush = Current.PushedForwardCurrents();
                position += forwardpush;
                
                if (River.getRiver(position) == opp) {
                	River.setRiver(position, "½");
                } else if (River.getRiver(position) == " ") {
                	River.setRiver(position, boat);
                } else {
                	//testing
                }
                System.out.println("AND YOU HAVE BEEN PUSHED FORWARD BY A CURRENT (+" + forwardpush / 2 + ") !!" + " Boat 1 is at box " + ((position / 2) + 1) + " !!");
                
        	} else if (River.getRiver(position) == "#") {
        		if (position < 0) {
        			position = 0;
        		}
        		River.setRiver(position, " ");
        		int backwardpush = Trap.PushedBackwardTraps();
        		position -= backwardpush;
        		placement(position, boat, opp);
        		// the <0 part
        		System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!" + " Boat 1 is at box 1 as well!!");
        		
        	} else {
        		placement(position, boat, opp);
        		
        	}
                /*
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
                
                if (position < 0) {
                	position = 0;
                }
                
                if (collide(tempposition, 0, opp)) { //idk if the - here works
                	River.setRiver(position, boat);
                	
                } else {
                    River.setRiver(position, "½");
                }
                System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!" + " Boat 1 is at box 1 as well!!");

            } else if (collide(position, roll, opp)) {
            	River.setRiver(position, boat);
            	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " !!");
                
            } else {
            	River.setRiver(position - roll, " ");
            	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " as well!!");
            }
            */
        System.out.println();
        River.printRiver();
        }
		return position;
		
    }

    public static void placement(int position, String boat, String opp) {
        if (River.getRiver(position) == opp) {
        	River.setRiver(position, "½");
        	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " as well!!");
        	
        } else if (River.getRiver(position) == " ") {
        	River.setRiver(position, boat);
        	System.out.println("Boat " + boat + " is at box " + ((position / 2) + 1) + " !!");
        } else {
        	//testing
        }
        
        /* if ((River.getRiver(position - roll)) == "½") {
        	River.setRiver(position - roll, opp);
            return true;
        } else if (River.getRiver(position) == opp){
        	River.setRiver(position, "½");
            return false;
        } else {
        	River.setRiver(position - roll, " ");
            return true;
        }*/
    }

    public static int RollTheDice(){
        return ((random.nextInt(6) + 1) * 2);
    }
}