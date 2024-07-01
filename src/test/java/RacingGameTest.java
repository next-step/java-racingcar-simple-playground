import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fixture.Random4GeneratorImpl;
import racingcar.Car;
import racingcar.RacingGame;

class RacingGameTest {

    @Test
    @DisplayName("자동차들이 움직인다")
    void carsMove() {
        RacingGame racingGame = new RacingGame(
            List.of(new Car("1번차"), new Car("2번차"), new Car("3번차")),
            new Random4GeneratorImpl()
        );
        racingGame.move();

        assertSoftly(softly -> {
            softly.assertThat(racingGame.getCars().get(0).getPosition()).isEqualTo(1);
            softly.assertThat(racingGame.getCars().get(1).getPosition()).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("승자를 구한다")
    void getWinner() {
        RacingGame racingGame = new RacingGame(
            List.of(new Car("1번차"), new Car("2번차"), new Car("3번차")),
            new Random4GeneratorImpl()
        );
        racingGame.move();

        List<Car> winners = racingGame.getWinners();

        assertSoftly(softly -> {
            softly.assertThat(winners).hasSize(3);
            softly.assertThat(winners.get(0).getName()).isEqualTo("1번차");
            softly.assertThat(winners.get(0).getPosition()).isEqualTo(1);
        });
    }
}
