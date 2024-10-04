package racingcar.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MoveTest {
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void 안_움직임(final int moveValue){
        //Given
        Move move = new Move();

        //When & Then
        assertFalse(move.isMovable(moveValue));
    }

    @ParameterizedTest
    @ValueSource(ints={4,5,6})
    void 움직임(final int moveValue){
        //Given
        Move move = new Move();

        //When & Then
        assertTrue(move.isMovable(moveValue));
    }
}
