import java.util.Scanner;

public class River {
    private static String[][] array = new String[3][200];
    private static String difficulty;
	
	public River() {
        for (int i = 0; i < 200; i += 2) {
            array[0][i] = "=";
            array[0][i + 1] = "+";
            array[1][i + 1] = "|";
            array[1][i] = " ";
            array[2][i] = "=";
            array[2][i + 1] = "+";
        }
        array[1][0] = "½";
	}
	
    public static void printRiver() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    public static void findDifficulty() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Select a difficulty level (Easy, Normal, Hard): ");
            difficulty = input.next().toUpperCase();
            if (difficulty.equals("EASY")) {
                difficulty = "Easy";
                setDifficulty(difficulty);
                break;
            } else if (difficulty.equals("MEDIUM")) {
                difficulty = "Medium";
                setDifficulty(difficulty);
                break;
            } else if (difficulty.equals("HARD")) {
                difficulty = "Hard";
                setDifficulty(difficulty);
                break;
            } else {
                System.out.println("Choose again !!");
            }
        }
    }

    public static void setDifficulty(String difficulty){difficulty = difficulty;}
    public static String getDifficulty(){return difficulty;}
    
	public static void setRiver (int position, String piece) {
		array[1][position] = piece;
	}
	
	public static String getRiver (int position) {
		return array[1][position]; 
	}

}
