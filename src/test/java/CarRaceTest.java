import NumberGenerator.FixNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {
    Race race;


    @Test
    void startRace() {

        Cars cars= new Cars(List.of("A", "B", "C"));

        race= new Race(cars);

        race.start(new FixNumberGenerator(new int[]{2,3,3}));
        race.start(new FixNumberGenerator(new int[]{2,3,3}));
        race.start(new FixNumberGenerator(new int[]{2,4,4}));
        race.start(new FixNumberGenerator(new int[]{4,4,4}));

        List<Car> winners = race.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getDistance()).isEqualTo(2);
    }
}
