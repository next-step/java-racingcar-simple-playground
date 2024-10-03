package domain;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private String[] carNames;

    //자동차 문자열 분리 메서드
    public void splitCarName(String input) {
        checkNull(input);
        carNames = input.split(",");
    }

    private int carSize(String[] carNames) {
        return carNames.length;
    }

    public List<Car> getCars(){
        return cars;
    }

    //경주 자동차 생성 메서드
    public void generateCar() {
        cars = new ArrayList<>(carSize(carNames));
        for (String carName : carNames) {
            checkNull(carName);
            checkLength(carName);
            cars.add(new Car(carName));
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
