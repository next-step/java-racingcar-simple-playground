package Car;

import java.util.Random;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    Random random = new Random();
    private static final int FORWARD_THRESHOLD = 4;

    public void move() {

        int roll = random.nextInt(10);
        if (roll >= FORWARD_THRESHOLD) {
            position++;
        }
    }
}
