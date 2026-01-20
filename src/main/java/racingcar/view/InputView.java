package racingcar.view;

import static racingcar.exception.InputErrorCode.ATTEMPT_NOT_NUMBER;
import static racingcar.exception.InputErrorCode.ATTEMPT_NOT_POSITIVE;
import static racingcar.exception.InputErrorCode.ATTEMPT_TOO_LARGE;
import static racingcar.exception.InputErrorCode.CAR_NAMES_BAD_FORMAT;
import static racingcar.exception.InputErrorCode.CAR_NAME_BLANK;
import static racingcar.exception.InputErrorCode.CAR_NAME_DUPLICATED;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.exception.InvalidInputException;

public class InputView {

    private static final int MAX_ATTEMPT_COUNT = 1000;
    private static final String CAR_NAME_SEPARATOR = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarNames() {
        String input = scanner.nextLine();
        validateCarNamesInput(input);
        return parseCarNames(input);
    }

    public int readAttempt() {
        String input = scanner.nextLine();
        int attempt = parseAttempt(input);
        validateAttempt(attempt);
        return attempt;
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(CAR_NAME_SEPARATOR))
                .map(String::trim)
                .toList();
        validateCarNames(carNames);
        return carNames;
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
