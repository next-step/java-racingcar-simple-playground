package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveConditionTest {

    @Test
    @DisplayName("생성된 숫자가 4 이상이면 이동 가능하다")
    void movableWhenNumberIsGreaterThanOrEqualToThreshold() {
        MoveCondition condition = new MoveCondition(() -> 4);

        assertThat(condition.isMoveable()).isTrue();
    }

    @Test
    @DisplayName("생성된 숫자가 3 이하면 이동 불가능하다")
    void notMovableWhenNumberIsLessThanThreshold() {
        MoveCondition condition = new MoveCondition(() -> 3);

        assertThat(condition.isMoveable()).isFalse();
    }
}
