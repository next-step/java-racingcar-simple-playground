package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import decider.StaticPositionDecider;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("횟수가 0 미만이면 실행 안 됨")
    void ifTimesUnderZero() {
        assertThatThrownBy(() -> new RacingGame(-5, new Car("1번 차", new StaticPositionDecider(5))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("times must be greater than 0");
    }

    @Test
    @DisplayName("참가자가 없으면 실행 안 됨")
    void ifCarNumberZero() {
        assertThatThrownBy(() -> new RacingGame(5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Racing cars must have at least one car");
    }

    @Test
    @DisplayName("1개의 참여자, 1번차 우승")
    void winnerOneCar() {

        final RacingGame racingGame = new RacingGame(
            10,
            new Car("1번 차", new StaticPositionDecider(5))
        );

        racingGame.race();
        final List<Car> winners = racingGame.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners)
            .extracting("name")
            .containsExactlyElementsOf(List.of("1번 차"));
    }

    @Test
    @DisplayName("우승자 여러 개인 경우, 4번차, 5번차 우승")
    void winnerSeveralCars() {

        final RacingGame racingGame = new RacingGame(
            5,
            new Car("1번 차", new StaticPositionDecider(1)),
            new Car("2번 차", new StaticPositionDecider(2)),
            new Car("3번 차", new StaticPositionDecider(3)),
            new Car("4번 차", new StaticPositionDecider(4)),
            new Car("5번 차", new StaticPositionDecider(5))
        );

        racingGame.race();
        final List<Car> winners = racingGame.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners)
            .extracting("name")
            .containsExactlyElementsOf(List.of("4번 차", "5번 차"));
    }
}
