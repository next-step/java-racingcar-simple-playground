import java.util.ArrayList;

public class CarRace {
    private final int carCount;
    private final int roundCount;
    private int maxPosition;
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;
    private NumberGenerator numberGenerator;

    public CarRace(ArrayList<Car> cars, int roundCount, NumberGenerator numberGenerator) {
        validateCars(cars);
        validateRoundCount(roundCount);

        carCount = cars.size();
        this.roundCount = roundCount;
        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 안 됨");
        }
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("roundCount가 0 이하임");
        }
    }

    public void race() {
        for (int i = 0; i < roundCount; i++) {
            moveCars(numberGenerator, 0, carCount);
        }
    }

    private void moveCars(NumberGenerator randomNumber, int start, int end) {
        for (int i = start; i < end; i++) {
            cars.get(i).moveCar(randomNumber);
        }
    }

    public ArrayList<Car> getWinners() {
        findMaxPosition();
        findWinners();
        return winners;
    }

    private void findMaxPosition() {
        int max;
        for (Car car : cars) {
            max = car.getLargerPosition(maxPosition);
            maxPosition = max;
        }
    }

    private void findWinners() {
        for (Car car : cars) {
            addWinners(car);
        }
    }

    private void addWinners(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }
}
