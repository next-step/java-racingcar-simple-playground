package domain.racegame;

import domain.car.AlwaysMoveStrategy;
import domain.car.Car;
import domain.car.Cars;
import domain.car.NeverMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {

        car1 = new Car("mong");
        car2 = new Car("ruka");
        car3 = new Car("dak");

        cars = new Cars(Arrays.asList(car1, car2, car3));
        racingGame = new RacingGame(cars, 3);
    }

    @Test
    @DisplayName("레이스 횟수가 1회 미만일 경우 예외가 발생한다.")
    public void shouldThrowException_WhenRaceCountIsLessThan_1() {
        assertThatThrownBy(() -> new RacingGame(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이스 횟수는 1회 이상이어야 합니다.");
    }

    @Test
    @DisplayName("1라운드 경주를 진행하면 현재 라운드가 증가한다.")
    public void testOneRoundRace_WhenRaceIsOngoing() {
        racingGame.playOneRoundRace(new AlwaysMoveStrategy());
        assertThat(racingGame.isRaceOngoing()).isTrue();
    }

    @Test
    @DisplayName("모든 라운드를 마치면 레이스가 종료된다.")
    public void testOneRoundRace_WhenRaceIsOver() {
        racingGame.playOneRoundRace(new AlwaysMoveStrategy());
        racingGame.playOneRoundRace(new AlwaysMoveStrategy());
        racingGame.playOneRoundRace(new AlwaysMoveStrategy());

        assertThat(racingGame.isRaceOngoing()).isFalse();
    }

    @Test
    @DisplayName("모든 라운드를 완료했을 때 우승자를 반환한다.")
    public void testGetWinners_AfterRaceCompletion() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car1.move(alwaysMoveStrategy, 5);
        car2.move(alwaysMoveStrategy, 5);
        car2.move(alwaysMoveStrategy, 5);
        car3.move(new NeverMoveStrategy(), 5);

        racingGame.playOneRoundRace(alwaysMoveStrategy);
        racingGame.playOneRoundRace(alwaysMoveStrategy);
        racingGame.playOneRoundRace(alwaysMoveStrategy);

        List<String> winners = racingGame.getWinners();

        assertThat(winners).hasSize(1).contains("ruka");
    }

    @Test
    @DisplayName("모든 자동차가 동일하게 이동했을 때 공동 우승자를 반환한다.")
    public void testGetWinners_WhenAllCarsHaveSamePosition() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car1.move(alwaysMoveStrategy, 5);
        car2.move(alwaysMoveStrategy, 5);
        car3.move(alwaysMoveStrategy, 5);

        racingGame.playOneRoundRace(alwaysMoveStrategy);

        List<String> winners = racingGame.getWinners();

        assertThat(winners).hasSize(3)
                .containsExactlyInAnyOrder("mong", "ruka", "dak");
    }

}

