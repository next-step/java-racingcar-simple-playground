package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final Random random;
    private int runCount;

    public RacingGame(Random random) {
        this.random = random;
    }

    public void initializeGame(String[] carNames, int runCount) {
        this.runCount = runCount;
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void playRound() {
        for (RacingCar car : racingCars) {
            car.move(random.nextInt(10));
        }
    }

    public int getRunCount() {
        return runCount;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getForwardCount)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getForwardCount() == maxPosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
