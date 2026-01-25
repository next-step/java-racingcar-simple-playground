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

    public List<MovingCar> getCars() {
        return Collections.unmodifiableList(movingCars); // 읽기 전용 리스트 반환
    }
}
