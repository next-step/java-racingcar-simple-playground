import java.util.ArrayList;
import java.util.List;

import view.ResultView;

public class CarSimulator {

    private final ArrayList<Car> cars = new ArrayList<>();
    private final int numberOfRounds;

    public CarSimulator(List<String> carNames, int numberOfRounds) {
        this.cars.addAll(getCars(carNames));
        this.numberOfRounds = numberOfRounds;
    }

    public void simulate() {
        ResultView.printResultHeader();
        for (int i = 0; i < numberOfRounds; i++) {
            moveCars();
            System.out.println();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            ResultView.printCarPosition(car.getName(), car.getPosition());
        }
    }

    public String getWinners() {
        int maxPosition = getWinnerPosition();

        return String.join(",",
            cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList()
        );
    }

    private int getWinnerPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("자동차가 없습니다."));
    }

    private ArrayList<Car> getCars(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

}
