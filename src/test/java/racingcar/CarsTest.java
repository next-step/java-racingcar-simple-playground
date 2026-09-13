package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차가 리스트에 저장이 잘 되는지 테스트")
    public void carsListTest() {
        Car a = new Car("A");
        Car b = new Car("B");
        Car c = new Car("C");
        Car d = new Car("D");
        Car e = new Car("E");

        Cars cars = new Cars(List.of(a, b, c, d, e));

        assertThat(cars.size()).isEqualTo(5);
    }
}
