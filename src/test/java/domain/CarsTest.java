package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {
    @Test
    void 라운드의_모든_자동차가_이동한다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(List.of(car1, car2));
        NumberGenerator generator = () -> 4;

        cars.move(generator);

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    void 단독_우승자를_찾는다() {
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
    void 공동_우승자를_찾는다() {
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
