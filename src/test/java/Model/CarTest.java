package Model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("4~9의 값이면 움직인다.")
    @Test
    void right_move(){
        int number = 4;
        Car car = new Car(new CarName("abc"));
        car.move(number);
        Assertions.assertThat(car.position).isEqualTo(1);
    }
}
