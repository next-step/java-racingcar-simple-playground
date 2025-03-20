package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void createCars(int carCount) {
        for(int i = 0; i < carCount; i++) {
            this.cars.add(new Car("car" + i));
        }
    }

    public void startRacing(int roundNum) {
        for(int i = 0; i < roundNum; i++) {
            round();
        }
    }

    private void round() {
        for(Car car:cars) {
            Random random = new Random();
            int num = random.nextInt(10);
            car.moveCar(num);
        }
    }

    public List<Car> findWinner() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }
}
