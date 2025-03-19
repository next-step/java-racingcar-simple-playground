/*
import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    public void testGetWinnerList() {
        Cars carList = Cars;
        racing.carList.add(new Car("A", new MovableNumberGenerator()));
        racing.carList.add(new Car("B", new NotMovableNumberGenerator()));
        racing.carList.add(new Car("C", new MovableNumberGenerator()));

        racing.carList.get(0).move(MOVE_FORWARD);
        racing.carList.get(1).move(NOT_MOVE);
        racing.carList.get(2).move(MOVE_FORWARD);

        racing.makeWinnerList();
        assertThat(game.winnerList).containsOnly(game.carList.get(0), game.carList.get(2));
    }

}
*/
