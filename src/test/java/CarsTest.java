import domain.movement.CarMovement;
import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 목록이 비어있으면 예외가 발생한다.")
    void throwsExceptionWhenNamesEmpty() {
        CarMovement carMovement = new FixedMovement(new int[]{});

        assertThatThrownBy(() -> new Cars(List.of(), carMovement))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 조건을 만족하면 자동차가 전진한다.")
    void movesCarWhenConditionMet() {
        Cars cars = new Cars(List.of("가"), new FixedMovement(new int[]{9}));

        cars.moveAll();

        assertThat(cars.findMaximum()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건을 만족하지 않으면 자동차가 전진하지 않는다.")
    void doesNotMoveCarWhenConditionNotMet() {
        Cars cars = new Cars(List.of("가"), new FixedMovement(new int[]{3}));

        cars.moveAll();

        assertThat(cars.findMaximum()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 큰 위치값을 찾는다.")
    void findsMaximumPosition() {
        Cars cars = new Cars(List.of("가", "나다", "라마바"),
                new FixedMovement(new int[]{9, 3, 9}));

        cars.moveAll();

        assertThat(cars.findMaximum()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 위치와 같은 자동차만 반환한다.")
    void filtersCarsByPosition() {
        Cars cars = new Cars(List.of("가", "나다", "라마바"),
                new FixedMovement(new int[]{9, 3, 9}));

        cars.moveAll();
        List<Car> filtered = cars.filterByPosition(1);

        assertThat(filtered).extracting(Car::getName).containsExactly("가", "라마바");
    }

    @Test
    @DisplayName("자동차 목록을 그대로 반환한다.")
    void returnsAllCars() {
        Cars cars = new Cars(List.of("가", "나다"), new FixedMovement(new int[]{9, 9}));

        List<Car> result = cars.getCars();

        assertThat(result).extracting(Car::getName).containsExactly("가", "나다");
    }
}