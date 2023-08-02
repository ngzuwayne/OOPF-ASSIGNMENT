import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{

        int score = 0;

        Score.createFileIfNotExists("scores.txt");

        Scanner input = new Scanner(System.in);
        // debatable if needed| River river = new River();
        
        System.out.println("Welcome to Boat Race!\n");

        River.findDifficulty();

        System.out.print("Please enter Player 1's name: ");
        String name1 = input.nextLine();
        System.out.print("Please enter Player 2's name: ");
        String name2 = input.nextLine();

        Player player1 = new Player();
        Player player2 = new Player();
        
        River river = new River();
        Current.PrintCurrents();
        Trap.PrintTraps();
        River.printRiver();

        while ((River.getRiver(198)) != "1" || (River.getRiver(198)) != "2") {
            player1.setName(name1);
            player1.setPosition(Boat.play("1", player1.getPosition(), "2"));
            player1.setScore(score);
            player2.setName(name2);
            player2.setPosition(Boat.play("2", player2.getPosition(), "1"));
            player2.setScore(score);
            score = score + 1;
        }
    }
}
