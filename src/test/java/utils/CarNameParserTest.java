package utils;

import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNameParserTest {

    @Nested
    @DisplayName("정상 입력 테스트")
    class SuccessCases {

        @Test
        @DisplayName("쉼표로 구분된 이름들을 정상적으로 파싱한다")
        void parseCommaSeparatedNames() {
            String input = "neo, brie, brown";

            List<Name> result = CarNameParser.parse(input);

            assertThat(result)
                    .extracting(Name::getValue)
                    .containsExactly("neo", "brie", "brown");
        }

        @Test
        @DisplayName("공백이 있어도 정상적으로 trim 후 파싱된다")
        void trimsWhitespace() {
            String input = "  a ,  b,  c  ";

            List<Name> result = CarNameParser.parse(input);

            assertThat(result)
                    .extracting(Name::getValue)
                    .containsExactly("a", "b", "c");
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class FailureCases {

        @Test
        @DisplayName("빈 문자열 입력 시 예외 발생")
        void emptyInputThrowsException() {
            String input = "";

            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 하며, 빈 값이 포함될 수 없습니다.");
        }

        @Test
        @DisplayName("이름 사이에 빈 항목이 있을 경우 예외 발생")
        void blankNameInListThrowsException() {
            String input = "neo, ,brie";

            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 하며, 빈 값이 포함될 수 없습니다.");
        }
    }
}
