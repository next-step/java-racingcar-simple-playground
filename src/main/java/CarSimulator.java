import java.util.ArrayList;
import java.util.Scanner;

public class CarSimulator {

    private static final String CAR_NAME_DELIMITER = ",";
    private final ArrayList<Car> cars = new ArrayList<>();
    private final int numberOfRounds;

    public CarSimulator(String carNames, String numberOfRounds) {
        this.cars.addAll(createCars(carNames));
        this.numberOfRounds = parsingNumberOfRounds(numberOfRounds);
    }

    public void start() {
        simulate();
        end();
    }

    private void simulate() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            for (Car car : cars) {
                car.move();
                car.displayPosition();
            }
            System.out.println();
        }
    }

    private void end() {
        int maxPosition = getWinnerPosition();

        String winners = String.join(",",
            cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList()
        );

        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private int getWinnerPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("자동차가 없습니다."));
    }

    private ArrayList<Car> createCars(String inputCarNames) {
        String[] CarNames = parsingCarNames(inputCarNames);
        ArrayList<Car> addCars = new ArrayList<>();

        for (String carName : CarNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }
            addCars.add(new Car(carName));
        }

        return addCars;
    }

    private int parsingNumberOfRounds(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("회수는 비어있을 수 없습니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("회수는 숫자여야 합니다.");
        }

        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("회수는 0보다 큰 숫자여야 합니다.");
        }

        return Integer.parseInt(input);
    }

    private String[] parsingCarNames(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        if (!input.contains(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름은 '" + CAR_NAME_DELIMITER + "'로 구분되어 2대 이상이 존재해야합니다.");
        }

        return input.split(CAR_NAME_DELIMITER);
    }

}
