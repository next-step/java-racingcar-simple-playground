package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars); //외부에서 수정 못하게 막는거
    }

    public int size() {
        return cars.size();
    }

    private void move(RandomNumber randomNumber) {
        for (int i = 0; i < cars.size(); i++) {
            int number = randomNumber.getRandomNumber();
            cars.get(i).moveIfPossible(number);
        }
    }

    public void carRace(RandomNumber randomNumber, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            move(randomNumber);
        }
    }

    public List<Car> findWinner() {
        //최대위치인 차만 고르면됨
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addWinnerIfMatch(maxPosition, winners, i);
        }
        return winners;
    }

    private void addWinnerIfMatch(int maxPosition, List<Car> winners, int i) {
        Car car = cars.get(i);
        if (car.samePosition(maxPosition)) {
            winners.add(car);
        }
        //int carPosition = cars.get(i).getCarPosition();
        //if (carPosition == maxPosition) {
        //    winners.add(cars.get(i));
        //}
    }

    private int getMaxPosition() {//다른데서 쓸일 없으니까 여기서만 쓰니까 private
        int maxPosition = 0;
        for (Car car : cars) { //이게 최대위치 구한거
            maxPosition = Math.max(maxPosition, car.getCarPosition());
        }
        return maxPosition;
    }
}
