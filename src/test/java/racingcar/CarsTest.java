package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {


    @Test
    @DisplayName("자동차가 리스트에 저장이 잘 되는지 테스트")
    public void CarsListTest() {
        Car A = new Car("A");
        Car B = new Car("B");
        Car C = new Car("C");
        Car D = new Car("D");
        Car E = new Car("E");

        Cars cars = new Cars(List.of(A, B, C, D, E));

        assertThat(cars.size()).isEqualTo(5);
    }
}
