import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MoveCondition moveCondition;

    public RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public void run(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.attemptToMoveAll(moveCondition);
        }
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
