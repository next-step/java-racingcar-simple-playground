package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int carMoveBaseline = 4;
    private static final int validCarNameSize = 5;

    private int carPosition;
    private String carName;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void move(int randomDigit) {
        if (randomDigit >= carMoveBaseline) {
            go();
        }
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public static List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public static boolean isValidCarName(String carName) {
        if (carName.length() > validCarNameSize) {
            return false;
        }
        return true;
    }

    public static boolean isValidCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (!isValidCarName(name)) {
                return false;
            }
        }
        return true;
    }

    private void go() {
        carPosition++;
    }

}
