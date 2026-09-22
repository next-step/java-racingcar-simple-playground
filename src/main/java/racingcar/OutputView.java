package racingcar;

import java.util.List;

public class OutputView {
    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));

        }
    }
}