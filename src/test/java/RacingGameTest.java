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
        List<Car> cars = List.of(new Car("neo"), new Car("brie"));

        RacingGame game = new RacingGame(cars, new FixedNumberProvider(5));
        game.play(1);

        assertThat(cars).allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("position이 가장 높은 차가 승자로 반환")
    void getWinner_Car() {
        Car neo = new Car("neo");
        Car brie = new Car("brie");

        neo.move(5);
        neo.move(5);
        brie.move(5);

        RacingGame game = new RacingGame(List.of(neo, brie), new FixedNumberProvider(0));
        List<Car> winners = game.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("neo");
    }
}
