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

    public List<Car> findWinner() {
        //최대위치인 차만 고르면됨
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfMatch(maxPosition, winners, car);
        }
        return winners;
    }

    private void addWinnerIfMatch(int maxPosition, List<Car> winners, Car car) {
        if (car.samePosition(maxPosition)) {
            winners.add(car);
        }
    }

    private int getMaxPosition() {//다른데서 쓸일 없으니까 여기서만 쓰니까 private
        int maxPosition = 0;
        for (Car car : cars) { //이게 최대위치 구한거
            maxPosition = Math.max(maxPosition, car.getCarPosition());
        }
        return maxPosition;
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
}
