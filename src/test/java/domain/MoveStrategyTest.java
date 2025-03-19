package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoveStrategyTest {

    @Test
    @DisplayName("숫자가4 이상이면 true를 반환한다")
    void 숫자가4_이상이면_true를_반환한다() {
        //given
        MoveStrategy moveStrategy = new MoveStrategy();

        //when
        boolean isMove = moveStrategy.canMove(4);

        //then
        assertThat(isMove).isTrue();
    }

    @Test
    @DisplayName("숫자가3 이하면 false를 반환한다")
    void 숫자가3_이하면_false를_반환한다() {
        //given
        MoveStrategy moveStrategy = new MoveStrategy();

        //when
        boolean isMove = moveStrategy.canMove(3);

        //then
        assertThat(isMove).isFalse();
    }

}