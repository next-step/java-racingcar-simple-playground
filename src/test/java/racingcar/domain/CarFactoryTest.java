package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class CarFactoryTest {
    @DisplayName("받은 문자열을 ,를 기준으로 자동차를 만든다")
    @Test
    void createCarsTest() {
        // when
        List<Car> cars = CarsFactory.createCars("neo,brie,brown");

        // then
        assertThat(cars).hasSize(3);
        List<String> expectedNames = List.of("neo", "brie", "brown");
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(expectedNames.get(i));
        }

    }
}
