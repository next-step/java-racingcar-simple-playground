package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    private static final int NO_MOVE_RANDOM_VALUE = 3;
    private static final int FIRST_CAR_MOVE_RANDOM_VALUE = 5;
    private static final int SECOND_CAR_NO_MOVE_RANDOM_VALUE = 2;
    private static final int THIRD_CAR_MOVE_RANDOM_VALUE = 4;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("car1", "car2", "car3"));
        racingGame = new RacingGame(cars);
    }

    @Test
    @DisplayName("레이스 진행 시 3을 주면 자동차의 위치가 움직이지 않는 지 검증한다")
    void testRaceDoesNotMoveCars() {

        try (MockedStatic<RandomValueGenerator> mocked = Mockito.mockStatic(RandomValueGenerator.class)) {
            mocked.when(RandomValueGenerator::getRandomNumber).thenReturn(NO_MOVE_RANDOM_VALUE);

            racingGame.race();

            for (Car car : cars.getCars()) {
                assertThat(car.getPosition()).isEqualTo(0);
            }
        }
    }

    @Test
    @DisplayName("레이스 진행 시, 자동차의 위치가 무작위 값에 따라 다르게 전진하는 지 검증한다.")
    void testRaceMovesCarsRandomly() {

        try (MockedStatic<RandomValueGenerator> mocked = Mockito.mockStatic(RandomValueGenerator.class)) {
            mocked.when(RandomValueGenerator::getRandomNumber)
                    .thenReturn(FIRST_CAR_MOVE_RANDOM_VALUE)
                    .thenReturn(SECOND_CAR_NO_MOVE_RANDOM_VALUE)
                    .thenReturn(THIRD_CAR_MOVE_RANDOM_VALUE);

            racingGame.race();

            assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
            assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
            assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
        }
    }
}
