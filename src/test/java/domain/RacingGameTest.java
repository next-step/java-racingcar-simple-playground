package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void returnsSingleWinnerWhenOneCarLeads() {
        Car a = new Car("A", 7);
        Car b = new Car("B", 2);
        Cars cars = new Cars(List.of(a, b));
        RacingGame racingGame = new RacingGame(cars, new FixedRandomNumber(0));

        assertThat(racingGame.findWinners()).containsExactly(a);
    }

    @Test
    @DisplayName("공동 우승자가 있을 수 있다")
    void returnsMultipleWinnersWhenTied() {
        Car a = new Car("A", 3);
        Car b = new Car("B", 3);
        Cars cars = new Cars(List.of(a, b));
        RacingGame racingGame = new RacingGame(cars, new FixedRandomNumber(0));

        assertThat(racingGame.findWinners()).containsExactlyInAnyOrder(a, b);
    }
}
