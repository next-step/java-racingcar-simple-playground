package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultMoveConditionTest {

    @ParameterizedTest
    @DisplayName("랜덤값이 4 이상이면 true를 반환한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void return_true_when_number_is_four_or_more(int number) {
        MoveCondition moveCondition = new DefaultMoveCondition();

        boolean actual = moveCondition.movable(number);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 3 이하이면 false를 반환한다")
    @ValueSource(ints = {0, 1, 2, 3})
    void return_false_when_number_is_three_or_less(int number) {
        MoveCondition moveCondition = new DefaultMoveCondition();

        boolean actual = moveCondition.movable(number);

        assertThat(actual).isFalse();
    }
}
