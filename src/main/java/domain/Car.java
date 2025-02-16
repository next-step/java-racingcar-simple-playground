package domain;

import java.util.Random;

public class Car {

    private static final int MOVE_TRIGGER = 4;
    private final String name;
    private int position;
    private Random randomGenerator;

    public Car(String name, Random random) {
        this.name = name;
        this.position = 0;
        this.randomGenerator = random;
    }

    public void move() {
        int randomValue = randomGenerator.nextInt(10);
        if (randomValue >= MOVE_TRIGGER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
