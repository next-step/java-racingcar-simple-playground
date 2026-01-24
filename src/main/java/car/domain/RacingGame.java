package car.domain;

import car.domain.model.CarGroup;
import car.domain.model.Judge;
import car.domain.model.MovingCar;
import car.domain.strategy.MovingStrategy;
import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;
    private final Judge judge;

    public RacingGame(CarGroup carGroup, Judge judge) {
        this.carGroup = carGroup;
        this.judge = judge;
    }

    public void playOneRound(MovingStrategy movingStrategy) {
        carGroup.moveAllCars(movingStrategy);
    }

    public List<MovingCar> getCars() {
        return carGroup.getCars();
    }

    public List<MovingCar> getWinners() {
        return judge.findWinners(carGroup.getCars());
    }
}


