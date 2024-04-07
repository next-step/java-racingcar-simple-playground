import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RacingGameTest {

    @Test
    @DisplayName("움직인 횟수가 가장 많은 차를 우승자로 선정해야 한다.")
    void testGetWinners() {
        // Given
        RacingGame game = new RacingGame();
        game.setRounds(5); // Assume 5 rounds of racing

        game.addCars("Car1");
        game.addCars("Car2");
        game.addCars("Car3");

        // When
        game.play();
        List<Car> cars = game.getCars();
        List<Car> winners = game.getWinners();

        // Then
        assertThat(winners).isNotEmpty(); // 한 명 이상의 우승자가 있어야 한다.
        int maxMoves = winners.get(0).getNumberOfMoves();
        for (Car winner : winners) {
            assertThat(winner.getNumberOfMoves()).isEqualTo(maxMoves); // 우승자는 모두 움직인 횟수가 같아야 한다.
        }
        for (Car car : cars) {
            assertThat(car.getNumberOfMoves()).isLessThanOrEqualTo(maxMoves); // 참여한 자동차들의 움직인 횟수는 우승자의 움직인 횟수보다 작거나 같아야 한다.
        }
    }
}
