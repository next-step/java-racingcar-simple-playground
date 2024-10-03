package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("유효한 자동차 이름이 생성된다.")
    public void shouldCreateCarName_WhenValidNameGiven() {

        String validName = "abc";

        CarName carName = new CarName(validName);

        assertThat(carName.getName()).isEqualTo(validName);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다.")
    public void shouldThrowException_WhenNameExceedsMaxLength() {

        String invalidName = "abcdef";

        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이거나 빈 문자열일 경우 예외가 발생한다.")
    public void shouldThrowException_WhenNameIsBlank() {

        String blankName = "  ";

        assertThatThrownBy(() -> new CarName(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }
}
