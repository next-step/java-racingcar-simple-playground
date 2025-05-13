package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        cars = new Cars(List.of(car1, car2, car3));
    }

    @Test
    @DisplayName("모든 차가 이동한다")
    void moveAll() {
        cars.moveAll(() -> 5);
        assertThat(cars.getCars())
                .allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("우승자를 모두 출력한다")
    void getWinners() {
        car1.move(5);
        car2.move(5);
        car3.move(3);
        assertThat(cars.getWinners()).containsExactlyInAnyOrder(car1, car2);
    }
}