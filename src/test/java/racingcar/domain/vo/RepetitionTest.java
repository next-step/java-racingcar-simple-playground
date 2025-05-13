package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RepetitionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100, Integer.MAX_VALUE})
    @DisplayName("0 이상의 값으로 반복 횟수 생성 테스트")
    void createRepetition(int repetitionCount) {
        final Repetition repetition = new Repetition(repetitionCount);

        assertThat(repetition.value()).isEqualTo(repetitionCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100, Integer.MIN_VALUE})
    @DisplayName("음수 값으로 반복 횟수 생성 시 예외 발생 테스트")
    void createRepetitionFailNegativeValue(int negativeCount) {
        assertThatThrownBy(() -> new Repetition(negativeCount))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_REPETITION_NEGATIVE.getDescription());
    }

    @Test
    @DisplayName("0은 유효한 반복 횟수로 허용해야 한다")
    void zeroShouldBeValidRepetitionCount() {
        Repetition repetition = new Repetition(0);

        assertThat(repetition.value()).isZero();
    }

    @Test
    @DisplayName("최대 정수값은 유효한 반복 횟수로 허용해야 한다")
    void maxIntValueShouldBeValidRepetitionCount() {
        Repetition repetition = new Repetition(Integer.MAX_VALUE);

        assertThat(repetition.value()).isEqualTo(Integer.MAX_VALUE);
    }
}