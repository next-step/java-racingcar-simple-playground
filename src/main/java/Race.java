import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int rounds;
    private MoveCar moveCar;

    public Race(MoveCar moveCar) {
        this.cars = new ArrayList<>();
        rounds = 0;
        this.moveCar = moveCar;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void defineRounds(int rounds) {
        this.rounds = rounds;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            runRound();
        }
    }

    private void runRound() {
        for (Car car : cars) {
            moveCar.tryMove(car);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(maxPosition, car, winners);
        }

        return winners;
    }

    private void addWinner(int maxPosition, Car car, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getCarName());
        }

    }

}
