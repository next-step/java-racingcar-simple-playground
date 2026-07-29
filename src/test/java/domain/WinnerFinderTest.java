package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerFinderTest {

    @Test
    void findsTheFarthestCar() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move(4);
        woni.move(3);

        WinnerFinder winnerFinder = new WinnerFinder();

        assertThat(
                winnerFinder.findWinners(List.of(pobi, woni))
        ).containsExactly("pobi");
    }

    @Test
    void findsMultipleWinnersAtSamePosition() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move(4);
        woni.move(4);

        WinnerFinder winnerFinder = new WinnerFinder();

        assertThat(
                winnerFinder.findWinners(List.of(pobi, woni))
        ).containsExactly("pobi", "woni");
    }
}