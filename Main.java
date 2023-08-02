import java.io.PrintWriter;
import java.util.Scanner;

public class Main extends Score{
    public static void main(String[] args) {

        int score = 0;

        createFile();
        
        Scanner input = new Scanner(System.in);
        // debatable if needed| River river = new River();
        
        System.out.println("Welcome to Boat Race!\n");

        River.findDifficulty();

        System.out.print("Please enter Player 1's name: ");
        String name1 = input.nextLine();
        System.out.println("Please enter Player 2's name: ");
        String name2 = input.nextLine();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        
        River river = new River();
        Current.PrintCurrents();
        Trap.PrintTraps();
        River.printRiver();

        while ((River.getRiver(198)) != "1" || (River.getRiver(198)) != "2") {
            player1.setPosition(Boat.play("1", player1.getPosition(), "2"));
            player1.setScore(score);
            if (player1.getPosition() == 198) {break;}
            player2.setPosition(Boat.play("2", player2.getPosition(), "1"));
            player2.setScore(score);
            score = score + 1;
        }
        // I was thinking this is where the "YOU"VE WON" statement should be placed?? or should it be in the river/player class
    }
}
