package racingcar.view;

import static racingcar.exception.InputErrorCode.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.InvalidInputException;

public class ConsoleView {

    private final Scanner scanner;

    private static final int MAX_ATTEMPT_COUNT = 1000;

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

    public List<String> readCarNames() {
        print(INPUT_RACING_CAR_NAME);
        String input = scanner.nextLine();
        validateCarNamesInput(input);
        return parseCarNames(input);
    }

    public int readAttempt() {
        print(INPUT_ATTEMPT);
        String input = scanner.nextLine();
        int attempt = parseAttempt(input);
        validateAttempt(attempt);
        return attempt;
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


    private List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(CAR_NAME_SEPARATOR))
                .map(String::trim)
                .toList();
        validateCarNames(carNames);
        return carNames;
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


    private void validateCarNamesInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(CAR_NAME_BLANK);
        }
        if (!input.contains(CAR_NAME_SEPARATOR)) {
            throw new InvalidInputException(CAR_NAMES_BAD_FORMAT);
        }

        String[] tokens = input.split(CAR_NAME_SEPARATOR, -1);
        boolean hasEmptyToken = Arrays.stream(tokens)
                .map(String::trim)
                .anyMatch(String::isEmpty);

        if (hasEmptyToken) {
            throw new InvalidInputException(CAR_NAMES_BAD_FORMAT);
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new InvalidInputException(CAR_NAME_DUPLICATED);
        }
    }

    private int parseAttempt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new InvalidInputException(ATTEMPT_NOT_NUMBER);
        }
    }

    private void validateAttempt(int attempt) {
        if (attempt <= 0) {
            throw new InvalidInputException(ATTEMPT_NOT_POSITIVE);
        }
        if (attempt >= MAX_ATTEMPT_COUNT) {
            throw new InvalidInputException(ATTEMPT_TOO_LARGE);
        }
    }
}
