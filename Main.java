public class Main {
    public static void main(String[] args) {

        String[][] array = new String[3][201];

        Boat.NoMoreNull();
        Current.PrintCurrents();
        Trap.PrintTraps();
        Boat.river();

        while (array[1][198] != "1" || array[1][198] != "2") {
            Boat.play("1", "1");
            Boat.play("2", "2");
        }
    }
}
