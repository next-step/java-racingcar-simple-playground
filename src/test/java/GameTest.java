import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class GameTest {
    @Test
    void 자동차_전진_테스트() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"pobi", "crong"}, 5);

        RacingCar pobi = game.getRacingCars().get(0);
        pobi.move(4);
        assertEquals(1, pobi.getForwardCount());

        pobi.move(3);
        assertEquals(1, pobi.getForwardCount()); // 3 이하는 전진하지 않음
    }

    @Test
    void 우승자_선택_테스트() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"pobi", "crong"}, 5);

        game.getRacingCars().get(0).move(5); // pobi 1칸 전진
        game.getRacingCars().get(1).move(3); // crong 전진 없음

        List<String> winners = game.findWinners();
        assertEquals(Collections.singletonList("pobi"), winners);
    }
}
