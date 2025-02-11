package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private final String name;
    private int moveDistance = 1;

    private Car(String name) {
        this.name = name;
    }

    public static List<Car> getInstancesByNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void moveForwardOrStay() {
        int randomNumber = getRandomNumber();
        if (isMovable(randomNumber)) {
            moveDistance++;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveDistance);
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber > 3;
    }

}
