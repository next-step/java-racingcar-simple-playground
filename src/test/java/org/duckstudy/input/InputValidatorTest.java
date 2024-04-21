package org.duckstudy.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.duckstudy.output.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("입력값 검증 테스트")
class InputValidatorTest {

    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator(outputView);

    @Nested
    @DisplayName("입력값 검증 테스트")
    class inputValidationTest {
        @ParameterizedTest
        @MethodSource("methodSourceCarNameLengthTestArguments")
        @DisplayName("자동차 이름이 없거나 5글자 초과일 때 에러를 발생한다")
        void gameFailWhenCarNameLengthIsEmptyOrGreaterThan5(String[] carNames) {

            assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 1글자 이상 5자 이하만 가능합니다.\n");
        }

        private static Stream<Arguments> methodSourceCarNameLengthTestArguments() {
            return Stream.of(
                    Arguments.arguments((Object) new String[]{""}),
                    Arguments.arguments((Object) new String[]{"abcdef"})
            );
        }

        @Test
        @DisplayName("반복 횟수가 0 이하일때 에러를 발생한다")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() {
            int repetitionNum = 0;

            assertThatThrownBy(() -> inputValidator.validateRepetitionNum(repetitionNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복 횟수는 0보다 커야 합니다.\n");
        }
    }
}
