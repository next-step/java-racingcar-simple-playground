package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Number.IsMovable;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveAll(IsMovable isMovable) {
        for (Car car : cars) {
            move(car, isMovable);
        }
    }

    private void move(Car car, IsMovable isMovable) {
        if (isMovable.getcheck()) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);

        /*return this.cars;
         *위 방식을 안쓴 이유는 객체를 받아서 다른 메소드나 클래스에서
         *수정이 가능해 지기 때문에 위 컬렉션 메소드로 반환값 설정
         * */
    }
}
