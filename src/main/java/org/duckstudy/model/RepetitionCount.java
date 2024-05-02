package org.duckstudy.model;

public record RepetitionCount(int repetitionCount) {

    public static final int EXCLUSIVE_MIN_REPETITION_COUNT = 0;

    public RepetitionCount {
        validateRepetitionCount(repetitionCount);
    }

    private void validateRepetitionCount(int repetitionCount) {
        if (repetitionCount <= EXCLUSIVE_MIN_REPETITION_COUNT) {
            throw new IllegalArgumentException(String.format("반복 횟수는 %d보다 커야 합니다.\n", EXCLUSIVE_MIN_REPETITION_COUNT));
        }
    }
}
