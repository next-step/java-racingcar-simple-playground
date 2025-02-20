package domain;

import global.RandomNumberGenerator;
import global.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int moveDistance = 1;
    private final RandomUtil randomUtil;

    public Car(String name, RandomUtil randomUtil) {
        this.name = name;
        this.randomUtil = randomUtil;
    }

    public static List<Car> getInstancesByNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        RandomUtil randomUtil = new RandomNumberGenerator();

        for (String name : carNames) {
            validateInputName(name);
            cars.add(new Car(name, randomUtil));
        }

        return cars;
    }

    public void moveForwardOrStay() {
        int randomNumber = randomUtil.generateRandomNumber();
      
        if (isMovable(randomNumber)) {
            moveDistance++;
        }
    }

    private static void validateInputName(String inputName) {
        if (isIllegalInputName(inputName)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이내여야 합니다.");
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

    private boolean isMovable(int randomNumber) {
        return randomNumber > 3;
    }

}
