import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    final Race race = new Race();

    @Test
    void startRace() {
        final int count = 4;
        race.initCars("a");
        race.initCars("b");
        race.initCars("c");

        race.start(new FixNumberGenerator(2));
        race.start(new FixNumberGenerator(3));
        race.start(new FixNumberGenerator(4));
        race.start(new FixNumberGenerator(5));

        List<Car> winners = race.getWinner();

        assertThat(winners).hasSize(3);
        assertThat(winners.get(0).getDistance()).isEqualTo(2);
    }
}
