import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    @DisplayName("차 생성 및 이름 설정 값 확인")
    public void car_Class() {
        //given
        String carName = "붕붕";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("차량 움직임 판단에 따른 addMovingCnt 변수값 상승 확인")
    public void moving_Method() {
        //given
        Car car = new Car("붕붕");

        car.moving();
        int expected = 1;

        //then
        assertThat(car.getMovingCnt()).isEqualTo(expected);
    }
}
