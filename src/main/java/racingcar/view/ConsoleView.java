package racingcar.view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class ConsoleView {

    private final Scanner scanner;

    private static final String INPUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String INPUT_ATTEMPT = "시도할 회수는 몇회인가요?";

    private static final String RESULT_PREFIX = "실행 결과";
    private static final String POSITION_FORMAT = "-";
    private static final String NAME_POSITION_SEPARATOR = ": ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WIN_CAR_SEPARATOR = ", ";
    private static final String WIN_CAR_DESCRIPTION = "가 최종 우승했습니다.";


    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    // TODO: Car 이름 정책에 따라 예외처리하기
    public List<String> readCarNames() {
        print(INPUT_RACING_CAR_NAME);
        String carNames = scanner.nextLine();
        return formatCarName(carNames);
    }

    // TODO: 숫자 입력 아닐 시 예외처리하기
    public int readAttempt() {
        print(INPUT_ATTEMPT);
        String attempt = scanner.nextLine();
        return Integer.parseInt(attempt);
    }

    public void printRacePrefix() {
        print(RESULT_PREFIX);
    }

    public void printRoundResult(List<Car> cars) {
        print(formatRoundResult(cars));
    }

    public void printWinCars(List<Car> winCars) {
        print(formatWinCars(winCars) + WIN_CAR_DESCRIPTION);
    }

    private List<String> formatCarName(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR)).toList();
    }

    private String formatRoundResult(List<Car> cars) {
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

    private String formatCarPosition(int position) {
        return POSITION_FORMAT.repeat(position);
    }

    private String formatWinCars(List<Car> winCars) {
        return winCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WIN_CAR_SEPARATOR));
    }

    private void print(String value) {
        System.out.println(value);
    }
}
