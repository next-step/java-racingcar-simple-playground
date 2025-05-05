package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveConditionTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest(name = "생성된 숫자가 {0}일 때 이동 가능(true)을 반환한다")
        @ValueSource(ints = {4, 5, 6, 9})
        void returnTrueWhenNumberIsGreaterThanOrEqualToThreshold(int input) {
            NumberGenerator generator = () -> input;
            MoveCondition condition = new MoveCondition(generator);

            Assertions.assertThat(condition.isMoveable()).isTrue();
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest(name = "생성된 숫자가 {0}일 때 이동 불가(false)를 반환한다")
        @ValueSource(ints = {0, 1, 2, 3})
        void returnFalseWhenNumberIsLessThanThreshold(int input) {
            NumberGenerator generator = () -> input;
            MoveCondition condition = new MoveCondition(generator);

            Assertions.assertThat(condition.isMoveable()).isFalse();
        }
    }
}
