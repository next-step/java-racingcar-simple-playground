package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 자동차를 움직인다.")
    @Test
    void move_all_car() {
        // given
        final Cars cars = new Cars(List.of(new Car("자동차1", new AlwaysMoveStrategy()), new Car("자동차2", new AlwaysNotMoveStrategy())));

        // when
        cars.move();

        // then
        final List<Car> result = cars.getCars();
        assertThat(result.get(0).getPosition()).isEqualTo(1);
        assertThat(result.get(1).getPosition()).isEqualTo(0);
    }

    @DisplayName("n대의 자동차 중에서 가장 많이 움직인 위치를 구한다.")
    @Test
    void get_max_position() {
        // given
        final Car car1 = new Car("자동차1", 10, new AlwaysMoveStrategy());
        final Car car2 = new Car("자동차2", 5, new AlwaysNotMoveStrategy());
        final Car car3 = new Car("자동차3", 10, new AlwaysNotMoveStrategy());
        final Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        final int result = cars.getMaxPosition();

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("n대의 자동차 중 가장 멀리 나간 자동차들을 구한다.")
    @Test
    void get_far_distance_cars() {
        // given
        final Car car1 = new Car("자동차1", 10, new AlwaysMoveStrategy());
        final Car car2 = new Car("자동차2", 5, new AlwaysNotMoveStrategy());
        final Car car3 = new Car("자동차3", 10, new AlwaysNotMoveStrategy());
        final Cars cars = new Cars(List.of(car1, car2, car3));
        final int maxPosition = cars.getMaxPosition();

        // when
        final List<Car> result = cars.getMaxMoveCars(maxPosition);

        // then
        assertThat(result).usingRecursiveComparison()
                .isEqualTo(List.of(car1, car3));
    }
}
