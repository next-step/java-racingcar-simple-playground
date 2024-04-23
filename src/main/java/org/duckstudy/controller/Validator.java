package org.duckstudy.controller;

import org.duckstudy.view.OutputView;

public class Validator {

    private final OutputView outputView;

    public Validator(OutputView outputView) {
        this.outputView = outputView;
    }

    public int validateRepetitionNum(int repetitionNum) {
        if (repetitionNum <= 0) {
            throw new IllegalArgumentException(outputView.getRepetitionNumExceptionMessage());
        }
        return repetitionNum;
    }
}
