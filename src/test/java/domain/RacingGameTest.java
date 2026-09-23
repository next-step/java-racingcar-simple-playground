package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 한_라운드를_진행하면_자동차들이_한번_이동한다() {
        // given
        Cars cars = Cars.from(new String[]{"car1", "car2"});
        NumberGenerator generator = () -> 4;
        RacingGame racingGame = new RacingGame(cars, generator);

        // when
        racingGame.race();

        // then
        assertThat(cars.iterateCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 1);
    }
}
