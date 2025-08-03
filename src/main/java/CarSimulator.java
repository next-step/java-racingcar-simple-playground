import java.util.ArrayList;
import java.util.Scanner;

public class CarSimulator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    private final ArrayList<Car> cars = new ArrayList<>();
    private int numberOfRounds;

    /*
     * 자동차 경주를 시작합니다.
     */
    public void start() {
        setup();
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

    private void setup() {
        String[] inputCarNames = inputCarNames();
        createCars(inputCarNames);
        this.numberOfRounds = inputNumberOfRounds();
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(CAR_NAME_DELIMITER);
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

    private void createCars(String[] inputCarNames) {
        for (String carName : inputCarNames) {
            if (!carName.isEmpty()) {
                this.cars.add(new Car(carName.trim()));
            }
        }
    }

    private int inputNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        return parsingNumberOfRounds(input);
    }

    private int parsingNumberOfRounds(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("회수는 숫자여야 합니다.");
        }
    }

}
