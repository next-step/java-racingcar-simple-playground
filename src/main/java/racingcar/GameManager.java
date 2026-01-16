package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;
    private static final String POSITION_FORMAT = "-";
    private static final String NAME_POSITION_SEPARATOR = ": ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public List<Car> cars;
    private Random random;
    private Scanner scanner;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public String inputCarName() {
        return scanner.nextLine();
    }

    // TODO: carName List 가 들어올 경우 Car List 로 한 번에 추가하기
    public void createCar(String carName) {
        Car car = new Car(carName);
        this.cars.add(car);
    }

    public int getRandomValue() {
        return random.nextInt(RANDOM_BOUND);
    }

    public void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.moveForward();
        }
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

        return result.toString();
    }

    private boolean canMove(int randomValue) {
        if (randomValue >= MIN_VALUE_TO_MOVE) {
            return true;
        }
        return false;
    }

    private String formatCarPosition(int position) {
        return POSITION_FORMAT.repeat(position);
    }
}
