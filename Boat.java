import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Main;

public class Boat {
    static String[][] array = new String[3][201];
    static int[] EvenNumbers = {2, 4, 6, 8, 10, 12};
    static Random random = new Random();
    static int steps = 0;
    static int step = 0;
    static int a = 0;
    static String name1;
    static String name2;

    public static void play (String boat, int position, String opp) {


        //change to main remove if'

        if (a == 0) {
            Scanner naming = new Scanner(System.in);


        }

        a = a + 1;

        Scanner presstoplay = new Scanner(System.in);
        System.out.printf("\nBOAT %s! IT'S YOUR TURN! \nPress ENTER to roll the dice: ", boat);
        presstoplay.nextLine();


        int roll = RollTheDice();
        position += roll;
        System.out.printf("\nYou rolled a %d ! ", roll / 2);






        if (position >= 198 || position >= 198) {
            array[1][198] = boat;
            array[1][position - roll] = " ";

            System.out.println();
            river();
            if (boat == "1"){
                System.out.println("Player " + boat + " has won!!");
                System.out.println(name1 + player1.getName);
            } else {
                System.out.println("Player " + opp + " has won!!");
                System.out.println(name2 + player);
            }

            System.exit(0);

        } else {
            if (array[1][position] == "C") {

                int forwardpush = Current.PushedForwardCurrents();
                position += forwardpush;
                if (collide()) {
                    array[1][position] = boat;
                }
                System.out.println("AND YOU HAVE BEEN PUSHED FORWARD BY A CURRENT (+" + forwardpush / 2 + ") !!" + " Boat 1 is at box " + ((steps / 2) + 1) + " !!");

            } else if (array[1][position] == "#") {

                int backwardpush = Trap.PushedBackwardTraps();
                position -= backwardpush;
                if (collide()) {
                    array[1][position] = boat;
                } else if (position < 0) {
                    position = 0;
                    collide();
                    System.out.println("BUT YOU HAVE BEEN PUSHED BACK BY A TRAP (-" + backwardpush / 2 + ") !!" + " Boat 1 is at box 1 as well!!");
                }

            } else if (collide()) {
                array[1][position] = "½";
                System.out.println("Boat " + boat + " is at box " + ((steps / 2) + 1) + " as well!!");
            } else {
                array[1][position] = boat;
                System.out.println("Boat " + boat + " is at box " + ((steps / 2) + 1) + " !!");

            }
        System.out.println();
        river();
        }
    }

    public static void river() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 201; j++) {
                System.out.print(Boat.array[i][j]);
            }
            System.out.println();
        }
    }
    public static void NoMoreNull(){
        for (String[] row : array) {
            Arrays.fill(row, " ");
        }

        for (int m = 0; m < 200; m += 2) {
            array[0][m] = "=";
            array[0][m + 1] = "+";
            array[1][m + 1] = "|";
            array[2][m] = "=";
            array[2][m + 1] = "+";
        }
    }

    public boolean collide(int position, int roll, String opp) {
        if ((array[1][position - roll]) == "½") {
            array[1][position - roll] = opp;
            return true;
        } else if (array[1][position] == opp){
            array[1][position] = "½";
            return false;
        } else {
            array[1][position - roll] = " ";
            return true;
        }

    }

    public static int RollTheDice(){
        return (EvenNumbers[random.nextInt(EvenNumbers.length)]);
    }
}