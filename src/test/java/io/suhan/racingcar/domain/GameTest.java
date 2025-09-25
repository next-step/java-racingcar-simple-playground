package io.suhan.racingcar.domain;

import static io.suhan.racingcar.domain.Car.CAR_MOVE_THRESHOLD;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.suhan.racingcar.generator.FixedNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class GameTest {
    @Test
    void n대의_자동차가_참여할_수_있다() {
        List<String> names = List.of("neo", "brie", "brown");

        Game game = Game.of();

        game.getCarRegistry().registerCars(names);

        List<String> registeredNames = game.getCarRegistry().getRegisteredCars().stream().map(Car::getName).toList();

        assertIterableEquals(names, registeredNames);
    }

    @Test
    void 누가_우승했는지를_구할_수_있다() {
        // given
        Game game = Game.of(5);

        FixedNumberGenerator forwardGenerator = new FixedNumberGenerator(CAR_MOVE_THRESHOLD);
        FixedNumberGenerator stopGenerator = new FixedNumberGenerator(CAR_MOVE_THRESHOLD - 1);

        Car neo = Car.of("neo", forwardGenerator);
        Car brie = Car.of("brie", stopGenerator);
        Car brown = Car.of("brown", forwardGenerator);

        game.getCarRegistry().register(neo);
        game.getCarRegistry().register(brie);
        game.getCarRegistry().register(brown);

        List<String> expectedNames = List.of("neo", "brown");

        // when
        game.execute();
        List<String> winnerNames = game.getWinners().stream().map(Car::getName).toList();

        // then
        assertIterableEquals(expectedNames, winnerNames);
    }

    @Test
    void 시도_횟수는_1_이상만_가능하다() {
        assertThrows(IllegalArgumentException.class, () -> Game.of(0));
    }
}
