package domain;

import view.ResultView;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGameService {

    private Cars cars;
    private Random random;

    public RacingGameService(Random random) {
        this.random = random;
    }

    public void carList(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(name -> new Car(name, random))
                .collect(Collectors.toList());
        this.cars = new Cars(carList);
    }

    public void gameStart(int rounds, ResultView resultView) {
        while (rounds-- > 0) {
            moveCars();
            resultView.printRoundResults(cars);
        }
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }

    public int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);  // 🚀 자동차가 없으면 0 반환
    }


    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public String findWinnerName() {
        return getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public Cars getCars() {
        return cars;

    }
}
