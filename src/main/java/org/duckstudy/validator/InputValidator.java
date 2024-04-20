package org.duckstudy.validator;

import java.util.Arrays;

public class InputValidator {

    public static final int MAX_NAME_LENGTH = 5;

    public InputValidator(int repetitionNum, String[] nameList)
            throws IllegalArgumentException {
        validateInput(repetitionNum, nameList);
    }

    private void validateInput(int repetitionNum, String[] nameList) {
        if (validateNameList(nameList)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5자 이하만 가능합니다.");
        }
        if (validateRepetitionNum(repetitionNum)) {
            throw new IllegalArgumentException("반복 횟수는 0보다 커야 합니다.");
        }
    }

    private boolean validateNameList(String[] nameList) {
        return Arrays.stream(nameList).anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private boolean validateRepetitionNum(int repetitionNum) {
        return repetitionNum <= 0;
    }
}
