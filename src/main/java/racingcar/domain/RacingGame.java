package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<Car> racingCars;
    private final int lapCount;
    private RandomNumGenerator randomNumGenerator;

    public RacingGame(List<Car> racingCars, int lapCount) {
        this.racingCars = racingCars;
        this.lapCount = lapCount;
        this.randomNumGenerator = new RandomNumGenerator();
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getLapCount() {
        return lapCount;
    }

    public List<Car> startLap() {
        for (Car racingCar : racingCars) {
            racingCar.moveCar(randomNumGenerator.makeNum());   //실제 랜덤넘버 만드는 것이 호출될 것임
        }
        return racingCars;
    }

}
