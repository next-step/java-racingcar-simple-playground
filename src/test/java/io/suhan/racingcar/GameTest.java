package io.suhan.racingcar;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

        for (String name : names) {
            Car car = Car.of(name);

            game.getCarRegistry().register(car);
        }

        List<String> registeredNames = game.getCarRegistry().getRegisteredCars().stream().map(Car::getName).toList();

        assertIterableEquals(names, registeredNames);
    }

    @Test
    void 누가_우승했는지를_구할_수_있다() {
        // given
        Game game = Game.of(5);

        FixedNumberGenerator forwardGenerator = new FixedNumberGenerator(4);
        FixedNumberGenerator stopGenerator = new FixedNumberGenerator(3);

        Car neo = Car.of("neo", forwardGenerator);
        Car brie = Car.of("brie", stopGenerator);
        Car brown = Car.of("brown", forwardGenerator);

        game.getCarRegistry().register(neo);
        game.getCarRegistry().register(brie);
        game.getCarRegistry().register(brown);

        List<String> expectedNames = List.of("neo", "brown");

        // when
        game.start();
        List<String> winnerNames = game.getWinners().stream().map(Car::getName).toList();

        // then
        assertIterableEquals(expectedNames, winnerNames);
    }
}
