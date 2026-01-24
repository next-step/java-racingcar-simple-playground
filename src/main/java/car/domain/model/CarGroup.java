package car.domain.model;

import car.domain.strategy.MovingStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CarGroup {

    private final List<MovingCar> movingCars;

    private CarGroup(List<MovingCar> cars) {
        this.movingCars = cars;
    }

    public static CarGroup from(List<String> carNames) {
        List<MovingCar> movingCars = carNames.stream()
            .map(Name::new)
            .map(MovingCar::new)
            .toList();
        return new CarGroup(movingCars);
    }

    public void moveAllCars(MovingStrategy movingStrategy) {
        for (MovingCar movingCar : movingCars) {
            movingCar.move(movingStrategy); // 각 자동차는 전달받은 전략에 따라 이동 여부 결정
        }
    }

    public List<MovingCar> findWinners() {
        List<MovingCar> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (MovingCar movingCar : movingCars) {
            addIfWinner(winners, movingCar, maxLocation); // 최대 위치와 같은 위치에 있는 자동차를 우승자로 추가
        }
        return winners;
    }

    private void addIfWinner(List<MovingCar> winners, MovingCar movingCar, int maxLocation) {
        if (movingCar.getLocation() == maxLocation) {
            winners.add(movingCar);
        }
    }

    private int getMaxLocation() {
        return movingCars.stream()
            .mapToInt(MovingCar::getLocation)
            .max()
            .orElse(0);
    }

    public List<MovingCar> getCars() {
        return Collections.unmodifiableList(movingCars); // 읽기 전용 리스트 반환
    }
}
