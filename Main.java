import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{

        String winner = null;
        String repeat;
        Score.createFileIfNotExists("TopScore.txt");

        Scanner input = new Scanner(System.in);
        do {
        	System.out.println("\n");
        	Score.displayScore();
            System.out.println("Welcome to Boat Race!\n");

            River.findDifficulty();

            System.out.print("Please enter Player 1's name: ");
            Player player1 = new Player(input.nextLine());
            System.out.print("Please enter Player 2's name: ");
            Player player2 = new Player(input.nextLine());
            
            River river = new River();
            Current.PrintCurrents();
            Trap.PrintTraps();
            River.printRiver();

            while (River.getRiver(198) != "1" && River.getRiver(198) != "2") {
            	
            	Player.setScore(1);
                player1.setPosition(Boat.play("1", player1.getPosition(), "2"));
                
                if (player1.getPosition() == 198) {
                	break; 
                }
                player2.setPosition(Boat.play("2", player2.getPosition(), "1"));
            }
            
            if (River.getRiver(198) == "1") {
            	Score.endGame(1, player1.getName(), Player.getScore());
            } else {
            	Score.endGame(2, player2.getName(), Player.getScore());
            }
            
            do {
            System.out.print("Do you want to play again? (Y/N): ");
            repeat = (input.nextLine()).toLowerCase();
            } while (!repeat.equals("n") & !repeat.equals("y"));
        } while (repeat.equals("y"));
        System.out.print("Thanks for playing!!!! :D");
        System.exit(0);
        
    }
}
