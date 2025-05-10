package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("값이 같은 Position은 동등하다")
        void equalWhenSameValue() {
            Position p1 = new Position(2);
            Position p2 = new Position(2);

            Assertions.assertThat(p1).isEqualTo(p2);
            Assertions.assertThat(p1).isNotSameAs(p2);
            Assertions.assertThat(p1.getValue()).isEqualTo(2);
        }

        @Test
        @DisplayName("동등한 Position은 hashCode도 동일하다")
        void hashCodeShouldMatchIfEqual() {
            Position a = new Position(4);
            Position b = new Position(4);

            Assertions.assertThat(a).isEqualTo(b);
            Assertions.assertThat(a.hashCode()).isEqualTo(b.hashCode());
        }

        @Test
        @DisplayName("forward는 기존 값보다 1 증가한 Position을 반환한다")
        void forwardCreatesNextPosition() {
            Position origin = new Position(0);
            Position moved = origin.forward();
            Assertions.assertThat(moved.getValue()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("음수 값으로 Position을 생성하면 예외가 발생한다")
        void throwWhenNegative() {
            assertThatThrownBy(() -> new Position(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Position.INVALID_POSITION_ERROR);
        }
    }
}
