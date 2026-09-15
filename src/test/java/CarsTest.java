import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {
    @Test
    @DisplayName("내부의 모든 자동차가 이동한다.")
    void moveCars() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(List.of(car1, car2));
        NumberGenerator generator = () -> 4;

        cars.move(generator);

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("단독 우승자를 찾는다.")
    void getSingleWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);

        car2.move(4);
        car2.move(4);

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.findWinners()).containsExactly(car2);
    }

    @Test
    @DisplayName("공동 우승자를 찾는다.")
    void getMultipleWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);

        car2.move(4);
        car2.move(4);

        car3.move(4);
        car3.move(5);

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.findWinners()).containsExactlyInAnyOrder(car2, car3);
    }
}
