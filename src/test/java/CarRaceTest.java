import static org.assertj.core.api.Assertions.assertThat;

import domain.Cars;
import domain.Race;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    @Test
    @DisplayName("3 이하면 전진, 4 이상이면 움직인다.")
    void moveTest() {

        Cars cars = new Cars(List.of("A", "B"));

        cars.moveAll(new FixNumberGenerator(new int[]{3, 4}));

        List<String> winners = cars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners).isEqualTo(List.of("B"));
    }

    @Test
    @DisplayName("단독 우승자 테스트")
    void getSingleWinnerTest() {

        int tryCount = 3;
        int[] fixedNumbers = new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5};
        Race race = new Race("A,B,C", new FixNumberGenerator(fixedNumbers));

        for (int i = 0; i < tryCount; i++) {
            race.start();
        }

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("C");
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void getCoWinnerTest() {

        int COUNT = 3;
        int[] fixedNumbers = new int[]{2, 4, 5, 3, 5, 9, 1, 4, 4};
        Race race = new Race("A,B,C", new FixNumberGenerator(fixedNumbers));

        for (int i = 0; i < COUNT; i++) {
            race.start();
        }

        List<String> winners = race.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains("B", "C");
    }
}
