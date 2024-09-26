package util;

import domain.Car;

import java.util.List;
import java.util.regex.Pattern;

public class InputFromUserValidator {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final Pattern NUMBER_FORMAT = Pattern.compile("[+-]?\\d*\\.?\\d+");


    public static void checkCarNames(List<String> carNames) {
        checkIsCarExists(carNames);
        for (String currentCarName : carNames) {
            checkCarNameLengthOverLimit(currentCarName);
            checkCarNameLengthUnderZero(currentCarName);
        }
    }

    private static void checkCarNameLengthOverLimit(String currentCarName) {
        if (currentCarName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 5를 넘어가는 자동차가 존재합니다. 다시 입력해 주세요.");
        }
    }

    private static void checkCarNameLengthUnderZero(String currentCarName) {
        if (currentCarName.isEmpty()) {
            throw new IllegalArgumentException("이름이 누락된 자동차가 존재합니다. 다시 입력해 주세요.");
        }
    }

    public static void checkExecutionsCount(String executionsCount) {
        if (!NUMBER_FORMAT.matcher(executionsCount).matches()) {
            throw new NumberFormatException("숫자가 아닙니다. 다시 입력해 주세요.");
        }
    }

    private static void checkIsCarExists(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다. 다시 입력해 주세요");
        }
    }
}
