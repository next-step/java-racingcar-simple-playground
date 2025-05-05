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
        @DisplayName("값이 같은 domain.Position 객체는 양방향 equals 비교 시 true를 반환한다")
        void positionEqualityIsSymmetric() {
            Position a = new Position(5);
            Position b = new Position(5);

            Assertions.assertThat(a).isEqualTo(b);
            Assertions.assertThat(b).isEqualTo(a);
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
        @DisplayName("forward는 기존 값보다 1 증가한 새로운 Position을 반환한다")
        void forwardCreatesNewPosition() {
            Position origin = new Position(0);
            Position moved = origin.forward();

            Assertions.assertThat(moved).isEqualTo(new Position(1));
            Assertions.assertThat(moved).isNotSameAs(origin);
            Assertions.assertThat(origin.getValue()).isEqualTo(0);
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

        @Test
        @DisplayName("null과 equals 비교하면 false를 반환한다")
        void notEqualToNull() {
            Position position = new Position(1);

            Assertions.assertThat(position).isNotEqualTo(null);
        }

        @Test
        @DisplayName("다른 클래스와 비교 시 동등하지 않다")
        void notEqualToDifferentClass() {
            Position position = new Position(1);
            String other = "1";

            Assertions.assertThat(position).isNotEqualTo(other);
        }
    }
}
