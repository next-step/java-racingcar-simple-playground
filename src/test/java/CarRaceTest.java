import static org.assertj.core.api.Assertions.assertThat;

import domain.Race;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    @Test
    @DisplayName("단독 우승자 테스트")
    void getSingleWinnerTest() {

        int tryCount = 3;
        Race race = new Race("A,B,C");

        for (int i = 0; i < tryCount; i++) {
            race.start(new FixNumberGenerator(new int[]{1, 2, 3}));
            race.start(new FixNumberGenerator(new int[]{2, 3, 4}));
            race.start(new FixNumberGenerator(new int[]{3, 4, 5}));

        }

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("C");
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void getCoWinnerTest() {

        int COUNT = 3;
        Race race = new Race("A,B,C");

        for (int i = 0; i < COUNT; i++) {
            race.start(new FixNumberGenerator(new int[]{2, 4, 5}));
            race.start(new FixNumberGenerator(new int[]{3, 5, 9}));
            race.start(new FixNumberGenerator(new int[]{1, 4, 4}));

        }

        List<String> winners = race.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains("B", "C");
    }
}
