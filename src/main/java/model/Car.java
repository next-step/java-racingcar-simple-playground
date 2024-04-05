package model;

import java.util.Random;

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

    public void move(){
        if(new Random().nextInt(10) > 3){
            score += 1;
        }
    }
}
