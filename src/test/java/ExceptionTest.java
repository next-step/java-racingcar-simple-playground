import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", "여섯자이상이름"})
    @DisplayName("자동차 이름 5자 넘어가거나 비어있으면 예외가 발생한다.")
    void car_name_length_Exception(String testCarName) {
        assertThatThrownBy(() -> new Car(testCarName)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "2222", "33333"})
    @DisplayName("자동차 이름 5자 이하면 정상이다.")
    void car_name_length_Non_Exception(String testCarName) {
        assertThatCode(() -> new Car(testCarName)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("자동차 이름이 null이거나 비어있으면 예외가 발생한다.")
    void car_name_blank_exception(String testCarName) {
        assertThatThrownBy(() -> new Car(testCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 중복이면 예외가 발생한다.")
    void duplicateCarNameThrowsException() {
        List<Car> cars = List.of(new Car("철수"), new Car("영희"), new Car("철수"), new Car("민수"));
        assertThatThrownBy(() -> new Cars(cars)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 중복 될 수 없습니다.");

    }
}