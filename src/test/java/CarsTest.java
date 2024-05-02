import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 자동차를 움직인다.")
    @Test
    void move_all_car() {
        // given
        final Cars cars = new Cars(List.of(new Car("안석환1", new AlwaysMoveStrategy()), new Car("안석환2", new AlwaysNotMoveStrategy())));

        // when
        cars.move();

        // then
        final List<Car> result = cars.getCars();
        assertThat(result.get(0).getPosition()).isEqualTo(1);
        assertThat(result.get(1).getPosition()).isEqualTo(0);
    }
}
