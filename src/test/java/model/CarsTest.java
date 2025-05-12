package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import model.dto.CarStatusDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("pobi", "dd", "juno"));
    }

    @Test
    @DisplayName("각 자동차들의 이름을 전달받아 정상적으로 자동차 객체가 생성된다.")
    void shouldCreateCar_whenInputCarsName() {
        // given & when & then
        assertThat(cars.getCarStatuses())
                .extracting(CarStatusDto::name)
                .containsExactly("pobi", "dd", "juno");
    }

    @Test
    @DisplayName("각 자동차에게 정상적으로 움직임 명령을 내린다.")
    void shouldMoveOrderToCar() {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        cars.move(alwaysTrueMoveStrategy);

        // then
        assertThat(cars.getCarStatuses())
                .extracting(CarStatusDto::position)
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
                .containsExactly("pobi", "dd", "juno");
    }
}
