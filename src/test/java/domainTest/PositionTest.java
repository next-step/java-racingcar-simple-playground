package domainTest;

import domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PositionTest {
    @Test
    @DisplayName("위치를 1 증가시킨다.")
    void moveForward() {
        Position position = new Position().next();
        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 값이면 참을 반환한다.")
    void returnTrueWhenSameValue() {
        Position position = new Position().next().next().next();
        assertTrue(position.isSameValue(3));
    }

    @Test
    @DisplayName("다른 값이면 거짓을 반환한다.")
    void returnFalseWhenDifferentValue() {
        Position position = new Position().next().next().next().next();
        assertFalse(position.isSameValue(3));
    }
}
