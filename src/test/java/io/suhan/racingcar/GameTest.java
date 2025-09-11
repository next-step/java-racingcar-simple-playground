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

        Game game = new Game();

        for (String name : names) {
            Car car = new Car(name);

            game.getCarRegistry().registerCar(car);
        }

        List<String> registeredNames = game.getCarRegistry().getRegisteredCars().stream().map(Car::getName).toList();

        assertIterableEquals(names, registeredNames);
    }

    @Test
    void 누가_우승했는지를_구할_수_있다() {
        Game game = new Game(5);

        FixedNumberGenerator forwardGenerator = new FixedNumberGenerator(4);
        FixedNumberGenerator stopGenerator = new FixedNumberGenerator(3);

        Car neo = new Car("neo", forwardGenerator);
        Car brie = new Car("brie", stopGenerator);
        Car brown = new Car("brown", forwardGenerator);

        game.getCarRegistry().registerCar(neo);
        game.getCarRegistry().registerCar(brie);
        game.getCarRegistry().registerCar(brown);

        game.start();

        List<String> winnerNames = game.getWinners().stream().map(Car::getName).toList();
        List<String> expectedNames = List.of("neo", "brown");

        assertIterableEquals(expectedNames, winnerNames);
    }
}
