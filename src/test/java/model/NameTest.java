package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름은 null이 될 수 없다.")
    @Test
    void validate_null() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동자 이름은 null이 될 수 없습니다.");
    }

    @DisplayName("이름은 빈칸이 될 수 없습니다.")
    @ValueSource(strings = {"", " ", "   "})
    @ParameterizedTest
    void validate_blank(String value) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 칸일 수 없습니다.");
    }

    @DisplayName("이름의 길이는 5자를 넘을 수 없습니다.")
    @ValueSource(strings = {"다섯글자넘다", "abcdefg"})
    @ParameterizedTest
    void validate_length(String value) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이는 5자를 넘길 수 없습니다.");
    }
}
