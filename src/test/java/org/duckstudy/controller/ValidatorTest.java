package org.duckstudy.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.duckstudy.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("검증 테스트")
class ValidatorTest {

    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator(outputView);

    @Nested
    @DisplayName("반복 횟수 검증 테스트")
    class RepetitonNumValidationTest {
        @Test
        @DisplayName("반복 횟수가 0보다 클때 성공한다")
        void gameSuccessWhenRepetitionNumIsGreaterThan0() {
            assertThatCode(() -> validator.validateRepetitionNum(1))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("반복 횟수가 0 이하일때 에러를 발생한다")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() {
            int repetitionNum = 0;

            assertThatThrownBy(() -> validator.validateRepetitionNum(repetitionNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복 횟수는 0보다 커야 합니다.\n");
        }
    }
}
