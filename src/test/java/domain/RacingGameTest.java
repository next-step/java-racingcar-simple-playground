package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 정해진_횟수만큼_자동차_경주를_진행한다() {
        NumberGenerator generator =
                new SequenceNumberGenerator(
                        List.of(4, 4, 4, 4, 4, 4)
                );

        RacingGame game = new RacingGame(
                List.of("pobi", "woni"),
                3,
                generator
        );

        List<List<Car>> results = game.race();

        assertThat(results).hasSize(3);
        assertThat(game.getWinners())
                .containsExactly("pobi", "woni");
    }

    @Test
    void 가장_멀리_이동한_자동차가_우승한다() {
        NumberGenerator generator =
                new SequenceNumberGenerator(
                        List.of(4, 3)
                );

        RacingGame game = new RacingGame(
                List.of("pobi", "woni"),
                1,
                generator
        );

        game.race();

        assertThat(game.getWinners())
                .containsExactly("pobi");
    }
}