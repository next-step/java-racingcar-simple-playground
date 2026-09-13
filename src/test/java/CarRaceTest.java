import NumberGenerator.FixNumberGenerator;
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

        race.start(new FixNumberGenerator(new int[]{2,3,3}));
        race.start(new FixNumberGenerator(new int[]{2,3,3}));
        race.start(new FixNumberGenerator(new int[]{2,4,4}));
        race.start(new FixNumberGenerator(new int[]{4,4,4}));

        List<Car> winners = race.getWinner();

        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getDistance()).isEqualTo(2);
    }
}
