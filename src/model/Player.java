package model;

public class Player {
    String name;
    int score;
    int power=3;
    boolean died=false;
    public Player(String name)
    {
        this.name=name;
        score=0;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power;}
    public boolean getDied() {
        return died;
    }

    public String getName() {
        return name;
    }

    public void setDied(boolean died) {
        this.died = died;
    }
}
