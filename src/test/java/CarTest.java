import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 정상적으로 이름을 갖는다.")
    void shouldReturnNameForCar() {
        // given
        Car car = new Car("jiyun");

        // when & then
        assertThat(car.getName()).isEqualTo("jiyun");
    }

}
