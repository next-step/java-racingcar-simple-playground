package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int moveDistance = 1;

    private Car(String name) {

        this.name = name;
    }

    public static List<Car> getInstancesByNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            validateInputName(name);
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

    private static void validateInputName(String inputName) {
        if (isIllegalInputName(inputName)) {
            throw new IllegalArgumentException("length of inputName must be less than 5 word and can't be empty.");
        }
    }

    public String getName() {
        return this.name;
    }

    private static boolean isIllegalInputName(String inputName) {
        return inputName == null || inputName.trim().isEmpty() || isLongerThan5(inputName);
    }

    private static boolean isLongerThan5(String inputName) {
        return inputName.length() > MAX_NAME_LENGTH;
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
