package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final Generator generator;

    public Cars(List<String> carNames, Generator generator) {
        this.generator = generator;
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carsList = new ArrayList<>();
        for (String name : carNames) {
            carsList.add(new Car(name, generator));
        }
        return carsList;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinner(List<String> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(car.getName());
        }
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    public void printCarStatuses(OutputHandler outputHandler) {
        for (Car car : cars) {
            outputHandler.printCarStatus(car);
        }
        outputHandler.printRoundEnd();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
