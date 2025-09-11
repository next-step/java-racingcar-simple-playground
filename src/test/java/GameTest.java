import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import io.suhan.racingcar.Car;
import io.suhan.racingcar.Game;
import io.suhan.racingcar.generator.FixedNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("n대의 자동차가 참여할 수 있다.")
    void registerableCars() {
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
    @DisplayName("누가 우승했는지를 구할 수 있다.")
    void getWinners() {
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
