import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{

        String winner = null;

        Score.createFileIfNotExists("scores.txt");

        Scanner input = new Scanner(System.in);
        // debatable if needed| River river = new River();
        
        System.out.println("Welcome to Boat Race!\n");

        River.findDifficulty();

        System.out.print("Please enter Player 1's name: ");
        Player player1 = new Player(input.nextLine());
        System.out.println("Please enter Player 2's name: ");
        Player player2 = new Player(input.nextLine());
        
        River river = new River();
        Current.PrintCurrents();
        Trap.PrintTraps();
        River.printRiver();

        while ((River.getRiver(198)) != "1" || (River.getRiver(198)) != "2") {
        	Player.setScore(1);
            player1.setPosition(Boat.play("1", player1.getPosition(), "2"));
            if (player1.getPosition() == 198) {
            	winner = player1.getName();
            	break; 
            }
            player2.setPosition(Boat.play("2", player2.getPosition(), "1")); 
            winner = player2.getName();
        }
        Score.endGame(winner, Player.getScore());
    }
}
