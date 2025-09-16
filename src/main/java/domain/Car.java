package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int carPosition;
    private String carName;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void move(int randomDigit) {
        if (randomDigit >= 4) {
            go();
            return;
        }
        stop();
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void resetPosition() {
        this.carPosition = 0;
    }

    public static List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    private void go() {
        carPosition++;
    }

    private void stop() {
        // 자동차가 정지한다.
    }
}
