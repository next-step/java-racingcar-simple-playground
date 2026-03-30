package racingcar.domain;

import java.util.Arrays;


class TestObstacles implements ObstaclesAhead {

    public static final Result[] RESULTS = {
            Result.AVOIDED,
            Result.BLOCKED,
            Result.AVOIDED, Result.AVOIDED, Result.AVOIDED,
            Result.BLOCKED, Result.BLOCKED,
            Result.AVOIDED,
            Result.BLOCKED,
            Result.AVOIDED, Result.AVOIDED,
            Result.BLOCKED,
            Result.AVOIDED, Result.AVOIDED, Result.AVOIDED, Result.AVOIDED,
            Result.BLOCKED, Result.BLOCKED, Result.BLOCKED, Result.BLOCKED, Result.BLOCKED,
    };

    public static final int AVOIDED_RESULT_COUNT = (int) Arrays.stream(RESULTS)
            .filter(v -> v == Result.AVOIDED)
            .count();


    private int index = 0;

    public TestObstacles() {
    }

    public TestObstacles(int index) {
        this.index = index;
    }


    @Override
    public Result tryAvoid() {
        Result value = RESULTS[index];
        index = (index + 1) % RESULTS.length;
        return value;
    }
}
