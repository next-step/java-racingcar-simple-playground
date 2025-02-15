package domain;

import java.util.Random;

public class Car {

    private static final int MOVE_TRIGGER = 4;
    private final String name;
    private int position;
    private Random randomValue = new Random();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int random = randomValue.nextInt(10);
        if (random >= MOVE_TRIGGER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
