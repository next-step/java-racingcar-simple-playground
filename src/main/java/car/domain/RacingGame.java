package car.domain;

import static car.domain.model.Judge.findWinners;

import car.domain.model.CarGroup;
import car.domain.model.Judge;
import car.domain.model.MovingCar;
import car.domain.strategy.MovingStrategy;
import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;

    public RacingGame(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    public void playOneRound(MovingStrategy movingStrategy) {
        carGroup.moveAllCars(movingStrategy);
    }

    public List<MovingCar> getCars() {
        return carGroup.getCars();
    }

    public List<MovingCar> getWinners() {
        return findWinners(carGroup.getCars());
    }
}


