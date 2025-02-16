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

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("car1", "car2", "car3"));
        racingGame = new RacingGame(cars);
    }

    @Test
    @DisplayName("레이스 진행 시 3을 주면 자동차의 위치가 움직이지 않는 지 검증한다")
    void testRaceDoesNotMoveCars() {

        try (MockedStatic<RandomValueGenerator> mocked = Mockito.mockStatic(RandomValueGenerator.class)) {
            mocked.when(RandomValueGenerator::getRandomNumber).thenReturn(3);

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
                    .thenReturn(5)
                    .thenReturn(2)
                    .thenReturn(4);

            racingGame.race();

            assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
            assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
            assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
        }
    }
}
