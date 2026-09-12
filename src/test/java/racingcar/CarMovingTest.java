package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovingTest {



    @DisplayName("4이상이면 전진")
    @ParameterizedTest //얘는 이재 밑에를 반복해서 테스트 실행할꺼다. 라는 것을 선언? 알리는 것
    @ValueSource(ints = {4, 5, 6, 7, 8, 9}) //이 값들을 가지고 반복해서 실행한다.
    public void moveForwardTest(int number) {
        Car car = new Car("TestCar");

        car.movePoint(number);

        assertThat(car.getCarPosition()).isEqualTo(1);
    }




    //@Test
    @DisplayName("3이하면 그대로")
    @ParameterizedTest //얘는 이재 밑에를 반복해서 테스트 실행할꺼다. 라는 것을 선언? 알리는 것
    @ValueSource(ints = {0, 1, 2, 3}) //이 값들을 가지고 반복해서 실행한다.
    public void notMoveForwardTest(int number) {
        Car car = new Car("TestCar");

        car.movePoint(number);

        assertThat(car.getCarPosition()).isEqualTo(0);
    }
}
