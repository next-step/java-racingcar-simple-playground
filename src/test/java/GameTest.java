import model.RacingCar;
import model.RacingGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Test
    void pickWinnerTest() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"neo", "brie"}, 5);

        game.getRacingCars().get(0).move(5);
        game.getRacingCars().get(1).move(3);

        List<String> winners = game.findWinners();
        assertEquals(Collections.singletonList("neo"), winners);
    }

    @Test
    void pickWinner2Test() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"neo", "brie"}, 5);

        List<String> winners = game.findWinners();
        assertEquals(List.of("neo", "brie"), winners);
    }

    @Test
    void pickMoreThanOneWinnerTest() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"neo", "brie"}, 5);

        game.getRacingCars().get(0).move(5);
        game.getRacingCars().get(1).move(5);

        List<String> winners = game.findWinners();
        assertEquals(
                List.of("neo", "brie"),
                winners
        );
    }

    @Test
    void randomMoveTest() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(10)).thenReturn(4, 2, 7, 8, 3);

        RacingGame game = new RacingGame(mockRandom);
        game.initializeGame(new String[]{"pobi", "crong"}, 5);

        game.playRound();
        assertEquals(1, game.getRacingCars().get(0).getForwardCount());
        assertEquals(0, game.getRacingCars().get(1).getForwardCount());

        game.playRound();
        assertEquals(2, game.getRacingCars().get(0).getForwardCount());
        assertEquals(1, game.getRacingCars().get(1).getForwardCount());
    }

    @Test
    void createCarsTest() {
        String[] names = {"pobi", "cron", "bob"};

        RacingGame game = new RacingGame(new Random());
        game.initializeGame(names, 1);

        List<RacingCar> cars = game.getRacingCars();

        assertEquals(3, cars.size());

        List<String> actualNames = cars.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
        assertEquals(List.of("pobi", "cron", "bob"), actualNames);
    }

    @Test
    void duplicateCarNameTest() {
        RacingGame game = new RacingGame(new Random());
        game.initializeGame(new String[]{"pobi", "pobi"}, 1);
        assertThat(game.getRacingCars()).hasSize(2);
    }
}
