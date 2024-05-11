package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름이 공백이거나 5자를 초과하는 경우 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"abcdef", "    "})
    void validateName(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이 아니며 5자 이하");
    }

    @DisplayName("유효한 자동차 이름이 주어지면 객체가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void createCarName(String input) {
        CarName carName = new CarName(input);
        assertThat(carName.name()).isEqualTo(input);
    }
}