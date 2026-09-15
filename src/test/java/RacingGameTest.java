import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameTest {
    @Test
    @DisplayName("경주 횟수만큼 자동차가 이동한다.")
    void movesCarsAsManyTimesAsRaceCount() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        NumberGenerator generator = () -> 4;

        RacingGame racingGame = new RacingGame(List.of(car1, car2), generator);

        racingGame.race(3);

        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(3);
    }
}
