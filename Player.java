public class Player {
    private static int score;
    private int position;
    private String name;


    Player(String name){
        position = 0;
        score = 0;
        this.name = name;
    }
    
    public String toString() {
        return String.format(" won with " + score / 2 + " moves!!");
    }

    public void setScore(int score) {
    	this.score = score;
    }
    
    public static int getScore(){
    	return score;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
