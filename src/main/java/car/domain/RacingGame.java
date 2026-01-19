package car.domain;

import java.util.List;

public class RacingGame {

    private final Car cars;

    public RacingGame(List<String> names) {
        this.cars = new Car(names);
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


