package domain;

import java.util.List;

public class CarRaceGame {

    private final List<Car> cars;

    public CarRaceGame(List<Car> cars) {
        this.cars = cars;
    }

    public void validateRoundNumber(int gameRound) {
        if (gameRound < 1 ) {
            throw new IllegalArgumentException("라운드는 한 번 이상 진행되어야 합니다.");
        }
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    private int getMaxDistance() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return maxDistance;
    }

    private List<String> getWinners(int maxDistance) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    public void playRacingGame(int gameRound) {
        validateRoundNumber(gameRound);

        for (int i=0; i < gameRound;i++) {
            playOneRound();
        }
    }

    public List<String> getWinnerNames() {
        List<String> winners = getWinners(getMaxDistance());

        if (winners == null) {
            throw new IllegalStateException("게임이 실행되지 않았습니다.");
        }
        return winners;
    }
}
