package org.duckstudy.input;

import java.util.Arrays;

public class InputValidator {

    public static final int MAX_NAME_LENGTH = 5;

    public InputValidator() {
    }

    public void validateInput(String[] carNames, int repetitionNum) {
        if (validateNameList(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5자 이하만 가능합니다.");
        }
        if (validateRepetitionNum(repetitionNum)) {
            throw new IllegalArgumentException("반복 횟수는 0보다 커야 합니다.");
        }
    }

    private boolean validateNameList(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private boolean validateRepetitionNum(int repetitionNum) {
        return repetitionNum <= 0;
    }
}
