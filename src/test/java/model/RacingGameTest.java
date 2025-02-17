package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class RacingGameTest {

    private static final int NO_MOVE_RANDOM_VALUE = 3;
    private static final int MOVE_RANDOM_VALUE = 5;

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("레이스 진행 시, 랜덤값이 5이면 자동차가 전진하는 지 검증한다.")
    void testRaceMovesCars() {
        RandomUtil fixedGenerator = new FixedNumberGenerator(MOVE_RANDOM_VALUE);

        RacingGame racingGame = new RacingGame(cars, fixedGenerator);

        racingGame.race();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("레이스 진행 시 랜덤값이 4 미만일 때 자동차가 전진하지 않는 지 검증한다.")
    void  testRaceDoNotMoveCars() {
        RandomUtil fixedGenerator = new FixedNumberGenerator(NO_MOVE_RANDOM_VALUE);

        RacingGame racingGame = new RacingGame(cars, fixedGenerator);

        racingGame.race();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
