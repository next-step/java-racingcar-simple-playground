package org.duckstudy.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("반복 횟수 검증 테스트")
class RepetitionCountTest {

    @Test
    @DisplayName("반복 횟수가 0보다 크면 성공한다")
    void createSuccessWhenRepetitionCountIsGreaterThan0() {
        assertThatCode(() -> new RepetitionCount(1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("반복 횟수가 0 이하이면 예외가 발생한다")
    void createFailWhenRepetitionCountIsEqualOrLessThan0() {
        assertThatThrownBy(() -> new RepetitionCount(0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
