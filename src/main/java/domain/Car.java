package domain;

import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_RANDOM_VALUE = 9;

    private final String name;
    private int position;
    private final Random random;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.random = new Random();
    }

    public Car(String name, Random random) {
        this.name = name;
        this.position = 0;
        this.random = random;
    }

    public void move() {
        int randomValue = generateRandomValue();
        if (shouldMove(randomValue)) {
            moveForward();
        }
    }

    private int generateRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE + 1);
    }

    private boolean shouldMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
