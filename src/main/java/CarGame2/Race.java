package CarGame2;

import java.util.List;

public class Race {

    private final Cars cars;
    private final int rounds;

    public Race(List<String> carNames, int rounds, Generator generator, OutputHandler raceOutput) {
        validateGenerator(generator);
        this.rounds = rounds;
        this.cars = new Cars(carNames, generator);
    }

    private void validateGenerator(Generator generator) {
        if (generator == null) {
            throw new IllegalArgumentException("Race에서 Generator가 null입니다.");
        }
    }

    public void playRound() {
        cars.moveAll();
    }

    public void printRaceStatus(OutputHandler outputHandler) {
        cars.printCarStatuses(outputHandler);
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

    public int getRounds() {
        return rounds;
    }

    public Cars getCars() {
        return cars;
    }
}
