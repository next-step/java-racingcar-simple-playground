import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름 확인 테스트(5글자 이하면 성공)")
    void carNameTest() {
        String carName = "자동차";
        int expectedPosition = 0;

        Car car = new Car(carName);
        String actualName = car.getName();
        int actualPosition = car.getPosition();

        assertThat(actualName).isEqualTo(carName);
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("자동차 이름이 5글자일 때 생성 성공 테스트")
    void carNameMaxLengthTest() {
        String carName = "다섯글자다";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과시 예외 발생 테스트")
    void carNameLengthTest() {
        String carName = "여섯글자이름";
        String throwMessage = "자동차 이름은 5자 이하만 가능합니다.";

        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(throwMessage);
    }

    @Test
    @DisplayName("자동차가 1칸 전진하는지 테스트")
    void carMoveTest() {
        int expectedPosition = 1;

        Car car = new Car("자동차");
        car.move();

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
