package racingcar;

import java.util.Random;

public class Car {

    private final String name;
    private final Random random;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.random = new Random();
    }

    public void move() {
        if (random.nextInt(10) % 10 >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
