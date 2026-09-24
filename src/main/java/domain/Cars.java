package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNoDuplicateNames(cars); //중복이름 예외검증
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars); //외부에서 수정 못하게 막는거
    }

    public int size() {
        return cars.size();
    }

    public void move(RandomNumber randomNumber) {
        for (int i = 0; i < cars.size(); i++) {
            int number = randomNumber.getRandomNumber();
            cars.get(i).moveIfPossible(number);
        }
    }

    //자동차 생성시키기(위치가 여기가 맞는것같음)
    public static Cars createCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameArray) {
            cars.add(new Car(name.trim(), 0));
        }
        return new Cars(cars);
    }

    private void validateNoDuplicateNames(List<Car> cars) {
        Set<String> duplicateNames = new HashSet<>(); //[학습] Set은 중복을 허용하지 않는 자료구조
        for (Car car : cars) {
            if (!duplicateNames.add(car.getCarName())) { //false면 중복이니까
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
                //중복 검증을 하여, 동일한 이름의 자동차가 존재하면 예외를 발생시킵니다.
            }
        }
    }

    //계산은 여기서
    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getCarPosition());
        }
        return maxPosition;
    }

    // 특정 위치에 있는 자동차들을 반환
    public List<Car> carsAt(int position) {   // "이 위치에 있는 차들 줘"
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.addAll(carAt(car, position));
        }
        return result;
    }
    //add로 하면 값을 car로 받아야하는데 이때 우승자가 없는경우 반환값을 정하기 어려워 addAll 사용

    private List<Car> carAt(Car car, int position) {
        if (car.samePosition(position)) {
            return List.of(car);
        }
        return List.of();
    }
}
