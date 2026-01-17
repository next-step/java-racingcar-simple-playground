package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameManager {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;
    private static final String POSITION_FORMAT = "-";
    private static final String NAME_POSITION_SEPARATOR = ": ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WIN_CAR_SEPARATOR = ", ";
    private static final String WIN_CAR_DESCRIPTION = "가 최종 우승했습니다.";

    private List<Car> cars;
    private final Random random;
    private final Scanner scanner;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public String readCarNames() {
        return scanner.nextLine();
    }

    public void setCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }


    public void race(int attempt) {
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                move(car, getRandomValue());
            }
        }
    }

    public void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.moveForward();
        }
    }

    public List<Car> getWinCars(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            String carName = car.getName();
            int position = car.getPosition();
            result.append(carName)
                    .append(NAME_POSITION_SEPARATOR)
                    .append(formatCarPosition(position))
                    .append(LINE_SEPARATOR);
        }

        List<Car> winCars = getWinCars(this.cars);
        result.append(formatWinCars(winCars))
                .append(WIN_CAR_DESCRIPTION);

        return result.toString();
    }

    private int getRandomValue() {
        return random.nextInt(RANDOM_BOUND);
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MIN_VALUE_TO_MOVE;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private String formatCarPosition(int position) {
        return POSITION_FORMAT.repeat(position);
    }

    private String formatWinCars(List<Car> winCars) {
        return winCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WIN_CAR_SEPARATOR));
    }
}
