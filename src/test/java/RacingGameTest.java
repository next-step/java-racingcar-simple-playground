import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    static class FixedNumberProvider extends RandomNumberProvider {
        private final int fixedNumber;

        public FixedNumberProvider(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int getRandomNumber() {
            return fixedNumber;
        }
    }

    @Test
    @DisplayName("게임이 진행될 때마다 position 값 update")
    void update() {
        List<String> carNames = List.of("neo", "brie");
        RacingGame game = new RacingGame(carNames, new FixedNumberProvider(5), 1);
        game.play(1);

        List<Car> cars = game.getCars();

        assertThat(cars).allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("position이 가장 높은 차가 승자로 반환")
    void getWinner_Car() {
        List<String> carNames = List.of("neo", "brie");
        RacingGame game = new RacingGame(carNames, new FixedNumberProvider(5), 2);
        game.play(2);

        List<Car> winners = game.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("neo", "brie");
    }
}
