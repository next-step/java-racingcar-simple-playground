package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int CAR_MOVE_BASE_LINE = 4;
    private static final int VALID_CAR_NAME_SIZE = 5;

    private int carPosition;
    private String carName;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void move(int randomDigit) {
        if (randomDigit >= CAR_MOVE_BASE_LINE) {
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

    public static boolean isValidCarNameLanguage(String carName) {
        if (carName == null || carName.isEmpty() || carName.isBlank()) {
            return false;
        }
        return carName.matches("^[A-Za-z]+$");
    }

    public static boolean isValidCarNamesLanguage(List<String> carNames) {
        return carNames.stream().allMatch(Car::isValidCarNameLanguage);
    }

    public static boolean isValidCarNameLength(String carName) {
        if (carName.length() > VALID_CAR_NAME_SIZE) {
            return false;
        }
        return true;
    }

    public static boolean isValidCarNamesLength(List<String> carNames) {
        return carNames.stream().allMatch(Car::isValidCarNameLength);
    }

    private void go() {
        carPosition++;
    }

}
