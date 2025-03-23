package domain;

import java.util.List;

public class Racing {

    private final Cars cars;
    MovingStrategy movingStrategy;

    public Racing(Cars cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public void round() {
        cars.move(movingStrategy);
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getCarList() { // for 테스트 코드
        return cars.getCars();
    }
}
