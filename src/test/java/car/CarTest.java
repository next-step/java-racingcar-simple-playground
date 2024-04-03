package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carNameTest() {
        String carName = "차이름";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void carMoveTest() {
        String carName = "차이름";
        Car car = new Car(carName);

        car.move(4);
        car.move(3);
        car.move(2);

        assertThat(car.getPosition()).isEqualTo(1);
    }



}