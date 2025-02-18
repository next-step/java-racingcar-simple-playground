package domain;

import java.util.Random;


public class Car {
    private final Random random = new Random();
    private String carName = "";
    private int curPos = 0;

    public Car(String inputCarName) {
        carName = inputCarName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPos() {
        return curPos;
    }

    public int moveCar() {
        int randomSpeed = random.nextInt(10);

        if (randomSpeed >= 4)
            curPos += 1;

        return curPos;
    }
}