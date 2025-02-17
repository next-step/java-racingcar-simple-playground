import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차_전진_기능_테스트")
    void testMove(){
        // given
        Car car = new Car("MAY");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차_정지_기능_테스트")
    void testStop(){
        // given
        Car car = new Car("MAY");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차_이름_테스트")
    void testInvalidCarName(){
        // given
        String invalidCarName = "TooLongName";

        // when / then
        assertThatThrownBy(() -> new Car(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}