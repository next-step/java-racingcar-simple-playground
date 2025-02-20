package domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);  // 불변 리스트로 변환
    }

    public List<Car> getCars() {
        return cars;
    }
}
