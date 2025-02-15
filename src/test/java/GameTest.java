import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class GameTest {
    @Test
    void 자동차_전진_테스트() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"neo", "brie"}, 5);

        RacingCar neo = game.getRacingCars().get(0);
        neo.move(4);
        assertEquals(1, neo.getForwardCount());

        neo.move(3);
        assertEquals(1, neo.getForwardCount());
    }

    @Test
    void 우승자_선택_테스트() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"neo", "brie"}, 5);

        game.getRacingCars().get(0).move(5);
        game.getRacingCars().get(1).move(3);

        List<String> winners = game.findWinners();
        assertEquals(Collections.singletonList("neo"), winners);
    }

}
