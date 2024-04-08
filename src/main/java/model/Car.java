package model;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move() {
        // random number > 3인 경우 score += 1
    }
}