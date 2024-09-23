package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    @Test
    @DisplayName("움직임 가능 여부 확인")
    void TestIsntMovable(){
        //Given
        Move move = new Move();

        //When & Then
        assertFalse(move.isMovable(1));//안 움직임
        assertFalse(move.isMovable(2));
        assertFalse(move.isMovable(3));
        assertTrue(move.isMovable(4));//움직임
        assertTrue(move.isMovable(5));
        assertTrue(move.isMovable(6));
    }
}
