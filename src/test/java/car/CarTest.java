package car;

import car.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5글자가 넘을 경우")
    public void carNameOver(){

    }
    @Test
    @DisplayName("자동차 이름이 중복될 경우")
    public void carNameDuplicate(){

    }
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

//        car.move(4);
//        car.move(3);
//        car.move(2);

        assertThat(car.getPosition()).isEqualTo(1);
    }



}