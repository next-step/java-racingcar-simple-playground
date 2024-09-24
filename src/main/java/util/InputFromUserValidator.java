package util;

import java.util.List;

public class InputFromUserValidator {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void checkCarNames(List<String> carNames) {
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
        if (!executionsCount.matches("[+-]?\\d*\\.?\\d+")) {
            throw new NumberFormatException("숫자가 아닙니다. 다시 입력해 주세요.");
        }
    }
}
