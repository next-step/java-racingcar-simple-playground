package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int MAX_CAR_NUMBER = 10;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        checkCarNumber(cars);
        checkDuplicates(cars);
        return new Cars(new ArrayList<>(cars));
    }

    public static void checkCarNumber(List<Car> cars) {
        if(cars.size() > MAX_CAR_NUMBER) {
            throw new IllegalArgumentException("[Error] 차의 개수는 10대를 초과할 수 없습니다.");
        }
    }

    public static void checkDuplicates(List<Car> cars) {
        if(hasDuplicates(cars)) {
            throw new IllegalArgumentException("[Error] 차의 이름은 중복될 수 없습니다.");
        }
    }

    private static boolean hasDuplicates(List<Car> cars) {
        Set<String> nameSet = new HashSet<>();
        return cars.stream()
                .map(Car::getName)
                .anyMatch(name -> !nameSet.add(name));
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public Cars findCarsHasSamePosition(int position) {
        List<Car> carsHasSamePosition = cars.stream()
                .filter(car -> car.hasSamePosition(position))
                .collect(Collectors.toList());

        return new Cars(carsHasSamePosition);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
