package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("pobi", "jiyun", "juno"));
    }

    @Test
    @DisplayName("각 자동차들의 이름을 전달받아 정상적으로 자동차 객체가 생성된다.")
    void shouldCreateCar_whenInputCarsName() {
        // given & when & then
        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "jiyun", "juno");
    }

    @Test
    @DisplayName("각 자동차에게 정상적으로 움직임 명령을 내린다.")
    void shouldMoveOrderToCar() {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        cars.move(alwaysTrueMoveStrategy);

        // then
        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("자동차들 중 우승자를 정상적으로 반환한다.")
    void shouldReturnWinnersOfCars() {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        cars.move(alwaysTrueMoveStrategy);

        // then
        assertThat(cars.findWinners())
                .containsExactly("pobi", "jiyun", "juno");
    }
}
