import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 확인 테스트(5글자 이하면 성공)")
    void CarNameTest() {
        String carName = "자동차";
        int expectedPosition = 0;

        Car car = new Car(carName);
        String actualName = car.getName();
        int actualPosition = car.getPosition();

        assertThat(actualName).isEqualTo(carName);
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과시 예외 발생 테스트")
    void CarNameLengthTest() {
        String carName = "여섯글자이름";
        String throwMessage = "자동차 이름은 5자 이하만 가능합니다.";

        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(throwMessage);
    }

    @Test
    @DisplayName("4이상일 때 자동차가 움직이는지 테스트")
    void CarMoveTest() {
        String carName = "자동차";
        int random = 4;
        int expectedPosition = 1;

        Car car = new Car(carName);
        car.move(random);
        int actualPosition = car.getPosition();

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("3이하일 때 자동차가 안 움직이는지 테스트")
    void CarNotMoveTest() {
        String carName = "자동차";
        int random = 3;
        int expectedPosition = 0;

        Car car = new Car(carName);
        car.move(random);
        int actualPosition = car.getPosition();

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}
