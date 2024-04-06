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
        int expectedMovingCnt = 0;

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getMovingCnt()).isEqualTo(expectedMovingCnt);
    }

    @Test
    @DisplayName("차량 움직임 판단")
    public void moving_Method() {
        //given
        Car car = new Car("붕붕");

        int moving = car.Moving();
        int rnd = car.getRnd();
        int expected = 0;

        // when
        if(rnd >= 4)
            expected = 1;

        //then
        assertThat(moving).isEqualTo(expected);
    }

    @Test
    @DisplayName("addMovingCnt 변수값 올라가는지 확인")
    public void addMovingCnt_Method() {
        //given
        String carName = "붕붕";
        Car car = new Car(carName);

        //when
        int movingCnt = car.getMovingCnt();
        int moving = car.Moving();

        car.addMovingCnt(moving);

        //then
        assertThat(car.getMovingCnt()).isEqualTo(movingCnt + moving);
    }

    @Test
    @DisplayName("승자 지정 및 반환 확인")
    public void win_Method() {
        //given
        Car car = new Car("붕붕");

        //when
        boolean expected = true;
        car.setWin(expected);

        //then
        assertThat(car.getWin()).isEqualTo(expected);
    }
}
