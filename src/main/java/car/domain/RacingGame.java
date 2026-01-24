package car.domain;

import car.domain.model.CarGroup;
import car.domain.model.MovingCar;
import car.domain.strategy.MovingStrategy;
import java.util.List;

public class RacingGame {

    private final CarGroup cars;

    public RacingGame(CarGroup cars) {
        this.cars = cars;
    }

    public void playOneRound(MovingStrategy movingStrategy) {
        cars.moveAllCars(movingStrategy);
    }

    public List<MovingCar> getCars() {
        return cars.getCars();
    }

    public List<MovingCar> getWinners() {
        return cars.findWinners();
    }
}


