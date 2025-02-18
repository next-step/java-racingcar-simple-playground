import domain.*;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


class RacingGameTest {

    private RacingGame racingGame;
    private static final List<String> CAR_NAMES = List.of("neo", "brie", "brown");
    private static final int NUMBER_OF_RACING = 5;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(CAR_NAMES, NUMBER_OF_RACING);
    }

    @Test
    @DisplayName("경기 횟수를 반환한다.")
    void shouldReturnRacingGameTryOutCount() {
        assertThat(racingGame.getRaceAttemptCount()).isEqualTo(NUMBER_OF_RACING);
    }

    @Test
    @DisplayName("랜덤값이 4라면 자동차는 전진해야 한다.")
    void shouldMoveCar_WhenRandomValueEqualTo4() {
        RacingGame racingGame = new RacingGame(CAR_NAMES, NUMBER_OF_RACING, () -> 4);
        racingGame.doRace();

        assertThat(racingGame.getCars())
                .extracting(Car::getPosition)
                .allMatch(position -> position > 0);
    }

    @Test
    @DisplayName("랜덤값이 3이면 자동차는 멈춰야 한다")
    void shouldNotMoveCar_WhenRandomValueEqualTo3() {
        RacingGame racingGame = new RacingGame(CAR_NAMES, NUMBER_OF_RACING, () -> 3);
        racingGame.doRace();

        assertThat(racingGame.getCars())
                .extracting(Car::getPosition)
                .allMatch(position -> position == 0);
    }

}
