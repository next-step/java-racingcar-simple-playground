package domain;

import utils.RaceUtils;

import java.util.List;

public class Race {
    private final RaceUtils raceUtils = new RaceUtils();
    public int carCount;
    public int raceTurn;

    public Race(int carCount, int raceTurn) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
    }

    public void initRace(List<Car> cars) {
        for (Car car : cars) {
            car.carPosition = 0;
        }
    }

    public List<Car> playRace(List<Car> cars, int raceTurn) {
        initRace(cars);
        for (int i = 0; i < raceTurn; i++) {
            raceUtils.playSingleTurn(cars);
        }
        return raceUtils.getWinner(cars);
    }
}
