import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;
import domain.RacingGame;

public class RacingTest {

    private RacingGame race;

    @Test
    @DisplayName("우승자를 반환한다.")
    public void getWinner() {
        race = new RacingGame();
        race.inputCarList("neo");
        List<Car> winners = race.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("neo");
    }

}
