package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 자동차들이_무조건_전진하는_가짜_기계로_우승자를_테스트한다() {
        RacingGame game = new RacingGame(Arrays.asList("pobi", "crong"), 1);

        NumberGenerator forwardGenerator = new ForwardNumberGenerator();

        game.playOneRound(forwardGenerator); // 모두가 9를 받아서 전진함

        List<Car> winners = game.getWinners();
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "crong");
    }
}
