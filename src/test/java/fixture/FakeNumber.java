package fixture;

import java.util.List;

public class FakeNumber {

    public static final int MOVE_NUMBER = 4;
    public static final int STOP_NUMBER = 3;
    public static final List<Integer> winnerNumbers = List.of(
            MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER
    );
    public static final List<Integer> winnersNumbers = List.of(
            MOVE_NUMBER, STOP_NUMBER, MOVE_NUMBER,
            MOVE_NUMBER, MOVE_NUMBER, MOVE_NUMBER,
            MOVE_NUMBER, MOVE_NUMBER, MOVE_NUMBER,
            MOVE_NUMBER, MOVE_NUMBER, MOVE_NUMBER,
            STOP_NUMBER, STOP_NUMBER, STOP_NUMBER
    );
}
