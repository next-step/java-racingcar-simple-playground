package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerFinderTest {

    @Test
    void 가장_멀리_이동한_자동차를_찾음() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move(4);
        woni.move(3);

        WinnerFinder winnerFinder = new WinnerFinder();

        assertThat(winnerFinder.findWinners(
                List.of(pobi, woni)
        )).containsExactly("pobi");
    }

    @Test
    void 같은_위치라면_공동_우승() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move(4);
        woni.move(4);

        WinnerFinder winnerFinder = new WinnerFinder();

        assertThat(winnerFinder.findWinners(
                List.of(pobi, woni)
        )).containsExactly("pobi", "woni");
    }
}