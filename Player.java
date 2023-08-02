public class Player {
    static private int score;
    private int position;
    private String name;


    Player(String name){
        position = 0;
        score = 0;
        this.name = name;
    }
    
    public String toString() {
        return String.format("%s won with " + score / 2 + " moves!!", name);
    }

    public static void setScore(int turns) { score += turns; }
    
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

    public String getName() { return name; }
}
