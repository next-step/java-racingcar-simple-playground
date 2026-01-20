package car.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CarGroup {

    private final List<MovingCar> cars;

    public CarGroup(List<MovingCar> cars) {
        this.cars = cars;
    }

    public static CarGroup from(List<String> carNames) {
        List<MovingCar> movingCars = carNames.stream()
            .map(MovingCar::new)
            .toList();
        return new CarGroup(movingCars);
    }

    public void moveAllCars(MovingStrategy movingStrategy) {
        for (MovingCar car : cars) {
            car.move(movingStrategy); // 각 자동차는 전달받은 전략에 따라 이동 여부 결정
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