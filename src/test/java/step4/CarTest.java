package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints={4,9})
    @DisplayName("random 값이 4 이상일 경우 전진")
    void carMoveForward(int randomNum){
        //given
        Car car = new Car("brown");
        int currentLocation = car.getPosition();

        //when
        car.forwardCar(randomNum);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(currentLocation+1);

    }

    @ParameterizedTest
    @ValueSource(ints={1,3})
    @DisplayName("random 값이 3 이하의 값이면 멈춘다")
    void carStop(int randomNum){
        //given
        Car car = new Car("brown");
        int currentLocation = car.getPosition();

        //when
        car.forwardCar(randomNum);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(currentLocation);

    }
}
