package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Nested
    @DisplayName("참가자의 이름과 관련된 검증 메소드 테스트")
    class ValidateParticipantName {

        private static Stream<Arguments> methodSourceOfValidateParticipantNames() {
            return Stream.of(
                Arguments.arguments(Arrays.asList("teo", "neooooo"), "neooooo"),
                Arguments.arguments(Arrays.asList("ttteoo", "neo"), "ttteoo"),
                Arguments.arguments(Arrays.asList("minjuuuu"), "minjuuuu")
            );
        }

        @ParameterizedTest(name = "{0}에서 {1}은 다섯 글자 이상의 이름이므로 예외 발생")
        @MethodSource("methodSourceOfValidateParticipantNames")
        @DisplayName("이름의 길이 검증")
        void 이름_길이_검증(List<String> inputNames, String exceptionName) {
            assertThatThrownBy(() -> Validator.validateParticipantNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Errors.getLengthOfCarNameError(exceptionName));
        }
    }

    @Nested
    @DisplayName("시도 횟수와 관련된 검증 메소드 테스트")
    class ValidateTryCount {

        @ParameterizedTest(name = "{0}은 음수이므로 예외 발생")
        @ValueSource(ints = {-1, -2, -10})
        @DisplayName("시도 횟수 검증")
        void 시도횟수_검증(int tryCount) {
            assertThatThrownBy(() -> Validator.validateRangeOfTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
        }
    }
}
