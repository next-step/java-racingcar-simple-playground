import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    private final int times;
    private final int carNum;

    public Game(int times, int carNum) {
        this.times = times;
        this.carNum = carNum;
    }

    public void gameStart() {
        if (cars.isEmpty()) {
            return;
        }

        for (int i = 0; i < times; i++) {
            turn();
        }
        findWinner();
    }

    public Car createCar(String name, NumberGenerator numberGenerator) {
        Car car = new Car(name, numberGenerator);
        cars.add(car);
        return car;
    }

    private void turn() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void findWinner() {
        int maxDistance = getMaxDistance();

        for (Car car : cars) {
            addIfWinner(car, maxDistance);
        }
    }

    private void addIfWinner(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }

    public List<Car> getWinners() {
        return winners;
    }

    private int getMaxDistance() {
        int max = cars.get(0).getDistance();

        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }
}
