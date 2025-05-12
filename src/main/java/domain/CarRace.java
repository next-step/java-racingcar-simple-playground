package domain;

import java.util.List;

public class CarRace {

    private static final String DISTANCE_EXPRESSION = "-";
    private final List<Car> cars;
    private final int gameRounds;
    private final NumberGenerator numberGenerator;
    private final StringBuilder gameRoundsOutput = new StringBuilder();
    private List<String> winnerCarNames;

    public CarRace(List<Car> cars, int gameRounds, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.gameRounds = gameRounds;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        playRounds();
        int maxDistance = getMaxDistanceFromCars();
        winnerCarNames = getWinnerCarNamesForMaxDistance(maxDistance);
    }

    private void playRounds() {
        for (int i = 0; i < gameRounds; i++) {
            moveCarsAndRecord();
            gameRoundsOutput.append("\n");
        }
    }

    private void moveCarsAndRecord() {
        cars.forEach(car -> {
            car.tryMoveByNumber(numberGenerator.generate());
            recordOutput(car);
        });
    }

    private void recordOutput(Car car) {
        gameRoundsOutput.append("\n").append(car.getName()).append(" : ")
                .append(DISTANCE_EXPRESSION.repeat(car.getDistance()));
    }

    private int getMaxDistanceFromCars() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }

    private List<String> getWinnerCarNamesForMaxDistance(int maxDistance) {
        return cars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName)
                .toList();
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }

    public String getGameRoundsOutput() {
        return gameRoundsOutput.toString();
    }
}
