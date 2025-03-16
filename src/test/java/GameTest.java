import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private static final int MOVE_FORWARD = 4;
    private static final int NOT_MOVE = 3;

    @Test
    public void testGetWinnerList() {
        Game game = new Game();
        game.carList.add(new Car("A"));
        game.carList.add(new Car("B"));
        game.carList.add(new Car("C"));

        game.carList.get(0).move(MOVE_FORWARD);
        game.carList.get(1).move(NOT_MOVE);
        game.carList.get(2).move(MOVE_FORWARD);

        game.makeWinnerList();
        assertThat(game.winnerList).containsOnly(game.carList.get(0), game.carList.get(2));
    }
}
