import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    private RacingGame racingGame;
    private static final List<String> CAR_NAMES = List.of("neo", "brie", "brown");
    private static final int RACE_TRY_OUY_COUNT = 5;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(CAR_NAMES, RACE_TRY_OUY_COUNT);
    }

    @Test
    @DisplayName("경기 횟수를 반환한다.")
    void shouldReturnRacingGameTryOutCount() {
        assertThat(racingGame.getRaceAttemptCount()).isEqualTo(RACE_TRY_OUY_COUNT);
    }

    @Test
    @DisplayName("자동차는 이동 조건을 만족하면 전진한다.")
    void shouldMoveCars_WhenConditionIsTrue() {
        RacingGame racingGame = new RacingGame(CAR_NAMES, 9);
        racingGame.doRace();
        List<Car> cars = racingGame.getCars();

        assertThat(cars)
                .extracting(Car::getPosition)
                .allMatch(position -> position > 0);
    }

    @Test
    @DisplayName("자동차는 이동 조건을 만족하지 않으면 멈춘다.")
    void shouldNotMoveCars_WhenConditionIsFalse() {
        RacingGame racingGame = new RacingGame(CAR_NAMES, 0);
        racingGame.doRace();
        List<Car> cars = racingGame.getCars();

        assertThat(cars)
                .extracting(Car::getPosition)
                .containsOnly(0);
    }

}
