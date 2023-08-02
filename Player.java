public class Player {
    private static int score;
    private int position;
    private static String name;


    Player(){
        position = 0;
        score = 0;
        setName(name);
    }
    
    public String toString() {
        return String.format(" won with " + score / 2 + " moves!!");
    }

    public void setScore(int score) { this.score = score; }
    
    public static int getScore(){
    	return score;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) { this.name = name; }

    public static String getName() { return name; }
}
