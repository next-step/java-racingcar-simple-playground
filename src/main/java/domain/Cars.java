package domain;

import java.util.ArrayList;
import java.util.List;
import numberGenerator.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public void printAll() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    /**
     * 우승자 구하기
     */
    public List<String> getWinner() {
        int max = getMax();

        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .map(Car::getName)
                .toList();
    }

    /**
     * 최대 거리 구하기
     */

    private int getMax() {

        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

}
