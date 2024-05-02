package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarNameTest {


    @Test
    @DisplayName("올바르지 않은 이름을 입력할 경우 예외가 발생한다")
    void wrongNameThrowException(){
        assertAll(
                () -> assertThatThrownBy(() -> new Car(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다."),
                () -> assertThatThrownBy(() -> new Car(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다."),
                () -> assertThatThrownBy(() -> new Car(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다."),
                () -> assertThatThrownBy(() -> new Car("123456"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.")
        );

    }
}
