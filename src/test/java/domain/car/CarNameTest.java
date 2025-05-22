package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.strategy.AlwaysMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 예외를 던진다")
    void throw_exception_nameLength_have_to_under_5() {
        //Given
        String carName = "5자이상의이름";

        //When & Then
        assertThatThrownBy(() -> new Car(carName, new AlwaysMoveStrategy(), 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 4자 이하일 때 잘 저장되는지 확인한다")
    void return_correct_name_when_carName_Length_under_4() {
        //Given
        String carName = "4자이하";

        //When
        Car car = new Car(carName, new AlwaysMoveStrategy(), 0);

        //Then
        assertThat(car.getCarName()).isEqualTo("4자이하");
    }
}
