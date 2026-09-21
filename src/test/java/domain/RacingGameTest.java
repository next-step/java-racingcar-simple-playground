package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void findsJointWinners() {
        Cars cars = new Cars(List.of("Green", "Blue", "Red"));
        RacingGame game = new RacingGame(
                cars,
                new FixedNumberGenerator(List.of(4, 4, 3))
        );

        game.race(1);

        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Green", "Blue");
    }

    @Test
    void rejectsEmptyCars() {
        assertThatThrownBy(() -> new Cars(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsNegativeRounds() {
        Cars cars = new Cars(List.of("Green"));
        RacingGame game = new RacingGame(
                cars,
                new FixedNumberGenerator(List.of(4))
        );

        assertThatThrownBy(() -> game.race(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void keepsPositionWhenRoundsAreZero() {
        Cars cars = new Cars(List.of("neo"));
        RacingGame game = new RacingGame(
                cars,
                new FixedNumberGenerator(List.of(4))
        );

        game.race(0);

        assertThat(game.getCars())
                .extracting(Car::getPosition)
                .containsExactly(0);
    }

    @Test
    void 생성된_숫자에_따라_자동차가_이동한다() {
        Cars cars = new Cars(List.of("Green", "Blue"));
        RacingGame game = new RacingGame(
                cars,
                new FixedNumberGenerator(List.of(4, 3))
        );

        game.race(1);

        assertThat(game.getCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 0);
    }
}
