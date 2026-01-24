package car.domain.model;

import java.util.List;

public class Judge {

    public List<MovingCar> findWinners(List<MovingCar> movingCars) {
        int maxLocation = getMaxLocation(movingCars);

        return movingCars.stream()
            .filter(movingCar -> movingCar.isAt(maxLocation))
            .toList();
    }

    private int getMaxLocation(List<MovingCar> movingCars) {
        return movingCars.stream()
            .mapToInt(MovingCar::getLocation)
            .max()
            .orElse(0);
    }

}
