import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import util.InputParser;

public class InputParserTest {

    @Nested
    class ParseCarNamesTest {

        @Test
        void 정상적인_자동차_이름_파싱() {
            // Given
            String input = "자동차1,자동차2,자동차3";

            // When
            List<String> result = InputParser.parseCarNames(input);

            // Then
            assertThat(result).hasSize(3);
            assertThat(result).containsExactly("자동차1", "자동차2", "자동차3");
        }

        @Test
        void 공백이_포함된_자동차_이름_파싱() {
            // Given
            String input = " 자동차1 , 자동차2 , 자동차3 ";

            // When
            List<String> result = InputParser.parseCarNames(input);

            // Then
            assertThat(result).hasSize(3);
            assertThat(result).containsExactly("자동차1", "자동차2", "자동차3");
        }

        @Test
        void 두_대의_자동차_파싱() {
            // Given
            String input = "자동차1,자동차2";

            // When
            List<String> result = InputParser.parseCarNames(input);

            // Then
            assertThat(result).hasSize(2);
            assertThat(result).containsExactly("자동차1", "자동차2");
        }

        @Test
        void null_입력시_예외_발생() {
            // Given
            String input = null;

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
        }

        @Test
        void 빈_문자열_입력시_예외_발생() {
            // Given
            String input = "";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
        }

        @Test
        void 공백만_있는_입력시_예외_발생() {
            // Given
            String input = "   ";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
        }

        @Test
        void 자동차_한_대만_입력시_예외_발생() {
            // Given
            String input = "자동차1";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상이어야 합니다.");
        }

        @Test
        void 빈_자동차_이름_포함시_예외_발생() {
            // Given
            String input = "자동차1,,자동차3";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 자동차 이름이 존재합니다.");
        }

        @Test
        void 공백만_있는_자동차_이름_포함시_예외_발생() {
            // Given
            String input = "자동차1,   ,자동차3";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 자동차 이름이 존재합니다.");
        }
    }

    @Nested
    class ParseNumberOfRoundsTest {

        @Test
        void 정상적인_회수_파싱() {
            // Given
            String input = "5";

            // When
            int result = InputParser.parseNumberOfRounds(input);

            // Then
            assertThat(result).isEqualTo(5);
        }

        @Test
        void 한_자리_수_회수_파싱() {
            // Given
            String input = "1";

            // When
            int result = InputParser.parseNumberOfRounds(input);

            // Then
            assertThat(result).isEqualTo(1);
        }

        @Test
        void 큰_수_회수_파싱() {
            // Given
            String input = "100";

            // When
            int result = InputParser.parseNumberOfRounds(input);

            // Then
            assertThat(result).isEqualTo(100);
        }

        @Test
        void null_입력시_예외_발생() {
            // Given
            String input = null;

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 비어있을 수 없습니다.");
        }

        @Test
        void 빈_문자열_입력시_예외_발생() {
            // Given
            String input = "";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 비어있을 수 없습니다.");
        }

        @Test
        void 공백만_있는_입력시_예외_발생() {
            // Given
            String input = "   ";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 비어있을 수 없습니다.");
        }

        @Test
        void 숫자가_아닌_입력시_예외_발생() {
            // Given
            String input = "abc";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 숫자여야 합니다.");
        }

        @Test
        void 음수_입력시_예외_발생() {
            // Given
            String input = "-1";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 숫자여야 합니다.");
        }

        @Test
        void 영_입력시_예외_발생() {
            // Given
            String input = "0";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 0보다 커야 합니다.");
        }

        @Test
        void 소수점_포함_입력시_예외_발생() {
            // Given
            String input = "3.5";

            // When & Then
            assertThatThrownBy(() -> InputParser.parseNumberOfRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회수는 숫자여야 합니다.");
        }
    }
}
