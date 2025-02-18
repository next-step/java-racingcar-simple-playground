package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fixture.FixedNumberProvider;

class CarTest {

    @Test
    @DisplayName("positive - 4 이상의 수일 경우 자동차가 움직인다.")
    void moveCar() {
        Car car = new Car("차");
        car.move(new FixedNumberProvider.Number4Provider());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("positive - 4 보다 작은 수일 경우 자동차가 움직이지 않는다.")
    void doNotMoveCar() {
        Car car = new Car("차차");
        car.move(new FixedNumberProvider.Number3Provider());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("negative - 이름이 null 혹은 Empty 경우 예외처리")
    void nameException() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }
}
