package CarGame2;

import java.util.Random;

public class Car {
    private static final int MIN_SPEED = 4;
    private final String name;
    private final Random random;
    private int position = 0;
    private int speed;

    public Car(String name) {
        this.name = name;
        this.random = new Random();
    }

    public void move() {
        speed = generateRandomSpeed();
        if (speed >= MIN_SPEED) {
            position += speed;
        }
    }

    private int generateRandomSpeed() {
        return random.nextInt(10);
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
