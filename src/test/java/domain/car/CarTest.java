package domain.car;

import domain.racegame.MoveStrategy;
import domain.racegame.RandomMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car1, car2, car3;
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        car1 = new Car("gold");
        car2 = new Car("ruka");
        car3 = new Car("dak");

        moveStrategy = new RandomMoveStrategy();
    }

    @Test
    @DisplayName("자동차는 숫자가 4 이상일 경우에 움직인다.")
    public void testCarMoves_WhenNumberIsMoreThanOrEqual_4() {
        car1.move(moveStrategy, 4);
        car2.move(moveStrategy, 7);
        car3.move(moveStrategy, 9);

        assertThat(car1.getCarPosition()).isEqualTo(1);
        assertThat(car2.getCarPosition()).isEqualTo(1);
        assertThat(car3.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 숫자가 4 미만인 경우에 멈춘다.")
    public void testCarDoesNotMove_WhenNumberIsLessThan_4() {
        car1.move(moveStrategy, 1);
        car2.move(moveStrategy, 2);
        car3.move(moveStrategy, 3);

        assertThat(car1.getCarPosition()).isEqualTo(0);
        assertThat(car2.getCarPosition()).isEqualTo(0);
        assertThat(car3.getCarPosition()).isEqualTo(0);

    }


}
