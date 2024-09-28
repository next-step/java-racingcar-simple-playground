package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    @DisplayName("안 움직임")
    void TestIsntMovable(final int moveValue){
        //Given
        Move move = new Move();

        //When & Then
        assertFalse(move.isMovable(moveValue));
    }

    @ParameterizedTest
    @ValueSource(ints={4,5,6})
    @DisplayName("움직임")
    void TestIsMovable(final int moveValue){
        //Given
        Move move = new Move();

        //When & Then
        assertTrue(move.isMovable(moveValue));
    }
}
