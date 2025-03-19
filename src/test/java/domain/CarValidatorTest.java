package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarValidatorTest {

    @Test
    @DisplayName("차량의 이름이 5자를 넘으면 예외를 던져야한다")
    void 차량의_이름이_5자를_넘으면_예외를_던져야한다() {
        assertThatThrownBy(() -> CarValidator.validateName("cartest"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차량의 이름이 5자를 안 넘으면 예외를 안 던져야한다")
    void 차량의_이름이_5자를_안_넘으면_예외를_안_던져야한다() {
        assertThatCode(() -> CarValidator.validateName("car"))
                .doesNotThrowAnyException();
    }
}