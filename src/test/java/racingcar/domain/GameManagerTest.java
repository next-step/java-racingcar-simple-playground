package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    @DisplayName("한 라운드를 진행하면 자동차 상태가 갱신되고, 우승자를 조회할 수 있다.")
    @Test
    void raceOneRound() {
        // given
        GameManager gameManager = new GameManager(new FixedRandom(4), List.of("A", "B"));

        // when
        gameManager.raceOneRound();

        // then
        assertAll(
                () -> assertThat(gameManager.getCars())
                        .extracting(Car::getPosition)
                        .containsExactly(1, 1),

                () -> assertThat(gameManager.getWinCars())
                        .extracting(Car::getName)
                        .containsExactlyInAnyOrder("A", "B")
        );
    }

    private static class FixedRandom extends Random {

        private final int value;

        private FixedRandom(int value) {
            this.value = value;
        }

        @Override
        public int nextInt(int bound) {
            return value;
        }
    }
}
