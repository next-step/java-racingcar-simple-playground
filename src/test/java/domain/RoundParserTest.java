package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundParserTest {

    @Test
    @DisplayName("정상적인 숫자 문자열 입력 시 해당 정수를 반환한다")
    void return_integer_when_given_valid_number_string() {
        //Given
        String input = "5";

        //When
        int round = RoundParser.parseRound(input);

        //Then
        assertThat(round).isEqualTo(5);
    }

    @Test
    @DisplayName("공백이 포함된 숫자 문자열 입력 시 해당 정수를 반환한다")
    void return_integer_when_given_contians_space_number() {
        //Given
        String input = "   123  ";

        //When
        int round = RoundParser.parseRound(input);

        //Then
        assertThat(round).isEqualTo(123);
    }

    @Test
    @DisplayName("숫자 사이 공백이 포함된 문자열 입력 시 예외를 던진다")
    void return_integer_when_given_contians_space_inner_number() {
        //Given
        String input = "   3  9  ";

        // When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효한 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외를 던진다")
    void exception_when_input_is_empty() {
        //Given
        String input = "";

        //When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 값은 입력할 수 없습니다. 라운드 수를 입력해주세요.");
    }

    @Test
    @DisplayName("null 입력 시 예외를 던진다")
    void exception_when_input_is_null() {
        //Given
        String input = null;

        //When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 값은 입력할 수 없습니다. 라운드 수를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자 외 문자 포함 입력 시 예외를 던진다")
    void exception_when_input_including_string() {
        //Given
        String input = "12a4";

        //When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효한 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자 외 문자 입력 시 예외를 던진다")
    void exception_when_input_is_string() {
        //Given
        String input = "string";

        //When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효한 숫자를 입력해주세요.");
    }


    @Test
    @DisplayName("0 이하 입력 시 예외를 던진다")
    void exception_when_input_is_under_0() {
        //Given
        String input = "-1";

        //When & Then
        assertThatThrownBy(() -> RoundParser.parseRound(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("라운드 수는 1 이상이어야 합니다.");
    }
}
