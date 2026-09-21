package domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(
            Cars cars,
            NumberGenerator numberGenerator
    ) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race(int rounds) {
        validateRounds(rounds);

        for (int round = 0; round < rounds; round++) {
            raceOneRound();
        }
    }

    public void race(int rounds, Runnable afterRound) {
        validateRounds(rounds);

        for (int round = 0; round < rounds; round++) {
            raceOneRound();
            afterRound.run();
        }
    }


    private void validateRounds(int rounds) {
        if (rounds < 0) {
            throw new IllegalArgumentException(
                    "횟수는 음수일 수 없습니다."
            );
        }
    }

    private void raceOneRound() {
        cars.move(numberGenerator);
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
