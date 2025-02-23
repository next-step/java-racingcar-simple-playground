package domain;

import view.ResultView;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGameService {

    private Cars cars;
    private final NumberGenerator randomGenerator;

    public RacingGameService(NumberGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void carList(List<String> carNames) {
        throwIfCarsListIsEmpty(carNames);

        List<Car> carList = carNames.stream()
                .map(name -> {
                    throwIfCarNameEmpty(name);
                    return new Car(name);
                })
                .collect(Collectors.toList());
        this.cars = new Cars(carList);
    }

    private static void throwIfCarNameEmpty(String car) {
        if (car.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private static void throwIfCarsListIsEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 리스트가 비어있을 수 없습니다.");
        }
    }

    public void gameStart(int rounds, ResultView resultView) {
        while (rounds-- > 0) {
            moveCars();
            resultView.printRoundResults(cars);
        }
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            car.move(randomGenerator.generate());
        }
    }

    public int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
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
