package racingcar.domain;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest implements MakeNumStrategy {

    @Override
    public int makeNum() {  //테스트에서는 makeNum이 랜덤한 넘버를 생성하는게 아니라, 항상 1을 반환한다
        return 1;
    }


    @Test
    @DisplayName("자동차는 이름을 가진다")
    void createCarWithName() {
        // given
        Car car = new Car("Car1");

        // when
        String carName = car.getName();

        // then
        assertThat(carName).isEqualTo("Car1");
    }

    @Test
    @DisplayName("자동차는 빈 이름을 가질 수 없다")
    void createCarWithNoName() {
        // given
        Car car = new Car(" ");

        //when

        //예외가 터질것임

    }


    @Test
    @DisplayName("자동차는 초기에 위치가 0이다")
    void createCarHasInitialLocationZero() {
        // given
        Car car = new Car("Car2");

        // when
        int location = car.getLocation();

        // then
        assertThat(location).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차_전진_테스트")
    void carMovingTest() {
        // given
        Car car = new Car("Car3");

        // when
        car.moveCar(4);

        // then
        assertEquals(1, car.getLocation());
    }

    @Test
    @DisplayName("자동차_전진하지_않는_테스트")
    void carNotMovingTest() {
        // given
        Car car = new Car("Car4");

        // when
        car.moveCar(3);

        // then
        assertEquals(0, car.getLocation());
    }
}
