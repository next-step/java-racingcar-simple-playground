package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력된 값이 빈 값이나 Null이 들어올 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyValue(String value) {
        // given & when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jiyuni", "jiyun"})
    @DisplayName("입력된 값이 5자를 넘어갈 경우 예외가 발생한다.")
    void shouldThrowException_whenOverMaxNameLength(String value) {
        // given & when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 최대 이름 길이에 맞게 입력해주세요.");
    }
}
