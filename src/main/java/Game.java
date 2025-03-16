import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Game {

    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();
    private final CarController carController = new CarController();
    private final NumberGenerator numberGenerator;
    private final int times;
    private final int carNum;

    public Game(int times, int carNum, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.times = times;
        this.carNum = carNum;
    }

    public void gameStart() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("차량이 없습니다");
        }

        for (int i = 0; i < times; i++) {
            turn();
        }
        findWinner();
    }

    public void addCar(Car car) {

        if (cars.size() >= carNum) {
            throw new IllegalStateException("차량의 수 초과입니다.");
        }
        cars.add(car);
    }

    private void turn() {
        for (Car car : cars) {
            int num = numberGenerator.getNumber();
            carController.moveIfCan(num, car);
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
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
