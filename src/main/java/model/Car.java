package model;

import java.util.concurrent.ThreadLocalRandom;

public class Car {

    final int MOVABLE_NUMBER = 4;
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = ThreadLocalRandom.current().nextInt(9);
        if (randomNumber >= MOVABLE_NUMBER) {
            ++position;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
