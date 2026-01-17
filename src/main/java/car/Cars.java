package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<MovingCar> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new MovingCar(name));
        }
    }

    public void moveAllCars(List<Integer> randomValues) { // 각 자동차에 대해 move 메서드 호출
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomValues.get(i));
        }
    }

    public List<MovingCar> findWinners() {
        List<MovingCar> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (MovingCar car : cars) {
            addIfWinner(winners, car, maxLocation); // 최대 위치와 같은 위치에 있는 자동차를 우승자로 추가
        }
        return winners;
    }

    private void addIfWinner(List<MovingCar> winners, MovingCar car, int maxLocation) {
        if (car.getLocation() == maxLocation) {
            winners.add(car);
        }
    }

    private int getMaxLocation() {
        int max = 0;
        for (MovingCar car : cars) {
            max = Math.max(max, car.getLocation());
        }
        return max;
    }

    public List<MovingCar> getCars() {
        return Collections.unmodifiableList(cars); // 읽기 전용 리스트 반환
    }
}