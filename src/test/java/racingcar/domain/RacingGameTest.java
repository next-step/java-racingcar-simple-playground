package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 자동차_이름들로_레이싱게임을_생성한다() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> cars = racingGame.getCars();

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }
}
