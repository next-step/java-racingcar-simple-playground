import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;

@ExtendWith(MockitoExtension.class)
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

    @Test
    void 랜덤_전진_테스트() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(10)).thenReturn(4, 2, 7, 8, 3); // 순서대로 반환

        RacingGame game = new RacingGame(mockRandom);
        game.initializeGame(new String[]{"pobi", "crong"}, 5);

        game.playRound(); // 1라운드 실행
        assertEquals(1, game.getRacingCars().get(0).getForwardCount()); // pobi(4)
        assertEquals(0, game.getRacingCars().get(1).getForwardCount()); // crong(2)

        game.playRound();
        assertEquals(2, game.getRacingCars().get(0).getForwardCount()); // pobi(7)
        assertEquals(1, game.getRacingCars().get(1).getForwardCount()); // crong(8)
    }

}
