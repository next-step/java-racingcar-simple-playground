package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoundParserTest {

    @Nested
    @DisplayName("정상 입력 테스트")
    class SuccessCases {

        @Test
        @DisplayName("숫자 문자열을 정상적으로 파싱한다")
        void parseValidNumber() {
            String input = "5";

            int result = RoundParser.parse(input);

            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("공백이 있어도 정상적으로 파싱한다")
        void trimsWhitespaceAndParses() {
            String input = "   3   ";

            int result = RoundParser.parse(input);

            assertThat(result).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class FailureCases {

        @Test
        @DisplayName("숫자가 아닌 문자열 입력 시 예외 발생")
        void nonNumericInputThrowsException() {
            String input = "abc";

            assertThatThrownBy(() -> RoundParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }

        @Test
        @DisplayName("빈 문자열 입력 시 예외 발생")
        void emptyInputThrowsException() {
            String input = "";

            assertThatThrownBy(() -> RoundParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
