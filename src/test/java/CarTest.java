import domain.Car;
import domain.CarName;

import utils.ImmovableNumberGenerator;
import utils.MovableNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUP() {
        car = new Car(new CarName("car1"));
    }

    @Test
    @DisplayName("주행 조건을 만족하면, Car의 MOVING_PACE 만큼 이동한다.")
    void move_whenGeneratedMovableNumber() {
        // when
        car.move(new MovableNumberGenerator());
        // then
        assertThat(car.getDistance()).isEqualTo(Car.MOVING_PACE);
    }

    @Test
    @DisplayName("주행 조건을 만족하지 못하면, 멈춘다.")
    void stop_whenGeneratedImmovableNumber() {
        // when
        car.move(new ImmovableNumberGenerator());
        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 인스턴스가 생성된 직후 distance는 0이다.")
    void distanceIsZero_givenCarIsNew() {
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
