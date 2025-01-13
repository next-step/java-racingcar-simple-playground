package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            distance++;
        }
    }
}
