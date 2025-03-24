package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("이름이 공백으로 되어있다면 예외가 발생된다.")
    void car_name_can_not_blank() {
        final String name = " ";

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있거나 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 6자 이상이라면 예외가 발생된다.")
    void car_name_length_is_under_6() {
        final String name = "greedy";

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}
