package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String input) {
        String[] names = input.split(",");
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
        validateDuplicate();
    }
    private void validateDuplicate(){
        long distinctCount = cars.stream()
                .map(Car::getName) // Car 객체에서 이름을 추출한다고 가정
                .distinct()
                .count();
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("[ERROR]중복된 자동차 이름이 존재합니다.");
        }
    }
    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
    }
    public List<Car> getCarList(){
        return cars;
    }
}
