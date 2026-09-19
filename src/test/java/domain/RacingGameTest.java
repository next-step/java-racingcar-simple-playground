package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameTest {
    @Test
    void 한_라운드를_진행하면_자동차들이_한번_이동한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(List.of(car1, car2));
        NumberGenerator generator = () -> 4;
        RacingGame racingGame = new RacingGame(cars, generator);

        // when
        racingGame.race();

        // then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }
}
