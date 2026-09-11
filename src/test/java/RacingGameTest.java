import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameTest {
    @Test
    void getSingleWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);

        car2.move(4);
        car2.move(4);

        RacingGame racingGame = new RacingGame(List.of(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactly(car2);
    }

    @Test
    void getMultipleWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);

        car2.move(4);
        car2.move(4);

        car3.move(4);
        car3.move(5);

        RacingGame racingGame = new RacingGame(List.of(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactlyInAnyOrder(car2, car3);
    }
}
