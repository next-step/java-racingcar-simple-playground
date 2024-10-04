package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private int carSize(String[] carNames) {
        return carNames.length;
    }

    public List<Car> getCars(){
        return cars;
    }

    //경주 자동차 생성 메서드
    public void generateCarWithNames(String[] carNames) {
        cars = new ArrayList<>(carSize(carNames));
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
    }

    //경주 자동차 이동 메서드
    public void moveCars() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    private void checkNull(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력될 수 없습니다.");
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자까지만 가능합니다.");
        }
    }
}
