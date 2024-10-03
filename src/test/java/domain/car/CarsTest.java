package domain.car;

import domain.racegame.MoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private MoveStrategy moveStrategy;
    private Car car1;
    private Car car2;
    private Car car3;
    private Cars cars;

    private final int fixedRandomNumber = 5;

    @BeforeEach
    public void setUp() {

        car1 = new Car("mong");
        car2 = new Car("ruka");
        car3 = new Car("dak");

        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    @DisplayName("자동차 수가 1대 이하일 경우 예외가 발생한다.")
    public void shouldThrowException_WhenInputInvalidCarCount() {

        assertThatThrownBy(() -> new Cars(Arrays.asList(new Car("abc"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 수는 최소 2대여야 합니다.");
    }

    @Test
    @DisplayName("모든 자동차가 조건에 관계없이 한 번씩 이동한다.")
    public void testOneRoundRace_WhenMoveStrategyReturnTrue() {

        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        cars.raceOneRound(alwaysMoveStrategy);

        assertThat(car1.getCarPosition()).isEqualTo(1);
        assertThat(car2.getCarPosition()).isEqualTo(1);
        assertThat(car3.getCarPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("모든 자동차가 조건에 관계없이 이동하지 않는다.")
    public void testOneRoundRace_WhenMoveStrategyReturnFalse() {
        MoveStrategy neverMoveStrategy = new NeverMoveStrategy();

        cars.raceOneRound(neverMoveStrategy);

        assertThat(car1.getCarPosition()).isEqualTo(0);
        assertThat(car2.getCarPosition()).isEqualTo(0);
        assertThat(car3.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("최대 위치를 가진 자동차의 위치를 반환한다.")
    public void testGetMaxPosition_WhenCarsHaveDifferentPositions() {
        car1.move(new AlwaysMoveStrategy(), 5);
        car2.move(new AlwaysMoveStrategy(), 5);
        car2.move(new AlwaysMoveStrategy(), 5);

        int maxPosition = cars.getMaxPosition();

        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차의 위치가 모두 같을 때, 동일한 최대 위치를 반환한다.")
    public void testGetMaxPosition_WhenAllCarsHaveSamePosition() {
        car1.move(new AlwaysMoveStrategy(), 5);
        car2.move(new AlwaysMoveStrategy(), 5);
        car3.move(new AlwaysMoveStrategy(), 5);

        int maxPosition = cars.getMaxPosition();

        assertThat(maxPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("제일 많이 이동한 자동차, 즉 우승자를 찾는다.")
    public void testFindWinners_WhenOneCarHasMaxPosition() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car1.move(alwaysMoveStrategy, fixedRandomNumber);
        car2.move(alwaysMoveStrategy, fixedRandomNumber);
        car2.move(alwaysMoveStrategy, fixedRandomNumber);

        car3.move(new NeverMoveStrategy(), fixedRandomNumber);

        List<String> winners = cars.findWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("ruka")).isTrue();

    }

    @Test
    @DisplayName("자동차의 위치가 모두 같을 때, 모두 우승자로 선정된다.")
    public void testFindWinners_WhenCarsHaveSameMaxPosition() {

        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car1.move(alwaysMoveStrategy, fixedRandomNumber);
        car2.move(alwaysMoveStrategy, fixedRandomNumber);
        car3.move(alwaysMoveStrategy, fixedRandomNumber);

        List<String> winners = cars.findWinners();

        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.contains("mong")).isTrue();
        assertThat(winners.contains("ruka")).isTrue();
        assertThat(winners.contains("dak")).isTrue();

    }

}

