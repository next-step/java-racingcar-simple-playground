package car.domain.model;

import java.util.List;

public class Round {

    private final List<MovingCar> carSnapshots; // 각 라운드의 자동차 상태

    public Round(List<MovingCar> currentCars) {
        this.carSnapshots = currentCars.stream()
            .map(MovingCar::createSnapshot)
            .toList();
    }

    public List<MovingCar> getCarSnapshots() {
        return carSnapshots;
    }

}
