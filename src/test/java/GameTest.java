import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void testGetWinnerList() {
        Game game = new Game();
        game.carList.add(new Car("A"));
        game.carList.add(new Car("B"));
        game.carList.add(new Car("C"));

        game.carList.get(0).move(4);
        game.carList.get(1).move(3);
        game.carList.get(2).move(4);

        game.makeWinnerList();
        assertEquals(true, game.winnerList.contains(game.carList.get(0)));
        assertEquals(false, game.winnerList.contains(game.carList.get(1)));
        assertEquals(true, game.winnerList.contains(game.carList.get(2)));
    }
}
