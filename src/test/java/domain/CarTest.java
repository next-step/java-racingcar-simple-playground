package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    @DisplayName("자동차가 움직일 수 있는 경우 전진한다.")
    @Test
    void moveWhenCanMove() {
        MoveStrategy mockStrategy = mock(MoveStrategy.class);
        when(mockStrategy.canMove()).thenReturn(true);

        Car car = new Car("test", mockStrategy);
        car.move();

        assertThat(car.getPos()).isEqualTo(1);
    }

    @DisplayName("자동차가 움직일 수 없는 경우 전진하지 않는다.")
    @Test
    void notMoveWhenCanNotMove() {
        MoveStrategy mockStrategy = mock(MoveStrategy.class);
        when(mockStrategy.canMove()).thenReturn(false);

        Car car = new Car("test", mockStrategy);
        car.move();

        assertThat(car.getPos()).isEqualTo(0);
    }
}