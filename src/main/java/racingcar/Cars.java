package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    private void move(RandomNumber randomNumber) {
        for (int i = 0; i < cars.size(); i++) {
            int number = randomNumber.getRandomNumber();
            cars.get(i).movePoint(number);
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
            addWinnerIfMatch(cars.get(i).getCarPosition(), maxPosition, winners, i);
        }
        return winners;
    }

    private void addWinnerIfMatch(int CarPosition, int maxPosition, List<Car> winners, int i) {
        if (CarPosition == maxPosition) {
            winners.add(cars.get(i));
        }
    }

    private int getMaxPosition() {//다른데서 쓸일 없으니까 여기서만 쓰니까 private
        int maxPosition = 0;
        for (int i = 0; i < cars.size(); i++) { //이게 최대위치 구한거
            maxPosition = compareMax(maxPosition, cars.get(i).getCarPosition());
        }
        return maxPosition;
    }

    private int compareMax(int maxPosition, int carPosition) {
        if (maxPosition < carPosition) {
            return carPosition;
        }
        return maxPosition;
    }
}
