package org.duckstudy.controller;

import java.util.Arrays;
import org.duckstudy.view.OutputView;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    private final OutputView outputView;

    public Validator(OutputView outputView) {
        this.outputView = outputView;
    }

    public String[] validateCarNames(String[] carNames) {
        boolean hasInvalidCarNames = Arrays.stream(carNames)
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
        if (hasInvalidCarNames) {
            throw new IllegalArgumentException(outputView.getCarNameExceptionMessage(MAX_NAME_LENGTH));
        }
        return carNames;
    }

    public int validateRepetitionNum(int repetitionNum) {
        if (repetitionNum <= 0) {
            throw new IllegalArgumentException(outputView.getRepetitionNumExceptionMessage());
        }
        return repetitionNum;
    }
}
