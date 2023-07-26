import java.util.Scanner;

public class Player {
    private int score;
    private int position;
    private String name;


    Player(int score, String name){
        setScore(score);
        position = 0;
        this.name = name;
    }

    public String toString() {
        return String.format(" won with " + score / 2 + " moves!!");
    }

    public void setScore(int score) {this.score = score;}
    public int getScore(){return this.score;}

    public void setPieceposition(int pieceposition) {
        this.position = pieceposition;
    }
    public int getPieceposition() {
        return position;
    }
}
