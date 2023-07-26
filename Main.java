import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] array = new String[3][201];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();

        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        Boat.NoMoreNull();
        Current.PrintCurrents();
        Trap.PrintTraps();
        Boat.river();

        while (array[1][198] != "1" || array[1][198] != "2") {
            Boat.play("1", player1.getPosition(), "2");
            Boat.play("2", player2.getPosition(), "1");
        }
    }
}
