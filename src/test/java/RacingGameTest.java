import domain.RacingGame;
import java.util.List;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("경주 게임이 올바른 수의 자동차로 생성되는지 확인하는 테스트")
    void testRacingGameCreation() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 5);

        assertThat(game.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("초기 상태에서 모든 자동차가 동일한 위치에 있으면 모두 우승자가 되는지 확인하는 테스트")
    void testInitialWinners() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 0);

        List<String> winners = game.getWinners();

        assertThat(winners).hasSize(3);
    }

    @Test
    @DisplayName("여러 자동차가 동일한 최고 위치에 있으면 모두 우승자가 되는지 확인하는 테스트")
    void testMultipleWinners() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 0);
        List<String> winners = game.getWinners();

        assertThat(winners).contains("car1", "car2", "car3");
    }

    @Test
    @DisplayName("자동차가 없으면 우승자도 없는지 확인하는 테스트")
    void testEmptyCarList() {
        List<String> emptyCars = new ArrayList<>();
        RacingGame game = new RacingGame(emptyCars, 5);

        List<String> winners = game.getWinners();

        assertThat(winners).isEmpty();
    }

    @Test
    @DisplayName("음수 경주 횟수로 게임을 생성하면 예외가 발생하는지 확인하는 테스트")
    void testNegativeRounds() {
        List<String> carNames = createCarNames();

        assertThatThrownBy(() -> new RacingGame(carNames, -1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 라운드 경주 후에도 모든 자동차가 동일 위치에서 우승자가 되는지 확인하는 테스트")
    void testZeroRounds() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 0);

        game.race();
        List<String> winners = game.getWinners();

        assertThat(winners).hasSize(3);
    }

    @Test
    @DisplayName("한 라운드 진행 후에도 자동차 수는 변경되지 않는지 확인하는 테스트")
    void testPlayOneRound() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 1);
        int initialCarCount = game.getCars().size();

        game.playOneRound();

        assertThat(game.getCars()).hasSize(initialCarCount);
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있어도 정상 동작하는지 확인하는 테스트")
    void testDuplicateCarNames() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car1");
        carNames.add("car2");

        RacingGame game = new RacingGame(carNames, 0);

        assertThat(game.getCars()).hasSize(3);
        assertThat(game.getWinners()).hasSize(3);
    }

    @Test
    @DisplayName("단일 자동차로 게임을 진행해도 정상 동작하는지 확인하는 테스트")
    void testSingleCar() {
        List<String> carNames = new ArrayList<>();
        carNames.add("onlyCar");

        RacingGame game = new RacingGame(carNames, 0);

        assertThat(game.getCars()).hasSize(1);
        assertThat(game.getWinners()).containsExactly("onlyCar");
    }

    @Test
    @DisplayName("많은 수의 라운드를 진행해도 정상 동작하는지 확인하는 테스트")
    void testManyRounds() {
        List<String> carNames = createCarNames();
        RacingGame game = new RacingGame(carNames, 100);

        game.race();

        assertThat(game.getCars()).hasSize(3);
        assertThat(game.getWinners()).isNotEmpty();
    }

    private List<String> createCarNames() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        return carNames;
    }
}
