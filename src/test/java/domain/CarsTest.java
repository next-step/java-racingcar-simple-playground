package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CarsTest {

    @DisplayName("주어진 자동차 이름들로 Cars 객체가 생성된다.")
    @Test
    void createCars() {
        MoveStrategy mockStrategy = mock(MoveStrategy.class);
        List<String> carNames = List.of("a", "b", "c");

        Cars cars = new Cars(carNames, mockStrategy);

        assertThat(cars.getCars()).hasSize(3)
                .extracting(Car::getName)
                .containsExactly("a", "b", "c");
    }
}