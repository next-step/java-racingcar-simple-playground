import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

import model.Car;
import model.RacingGame;
import model.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    private RacingGame racingGame;
    private RandomNumberGenerator mockedRandom;

    @BeforeEach
    void setUp() {
        // given
        List<Car> cars = Arrays.asList(new Car("MAY"), new Car("JUN"), new Car("JULY"));
        mockedRandom = mock(RandomNumberGenerator.class);
        racingGame = new RacingGame(cars, mockedRandom);
    }

    @Test
    @DisplayName("한_턴_동안의_레이스_진행_테스트")
    void testRaceSingleRound() {
        // given
        when(mockedRandom.generate()).thenReturn(4);

        // when
        racingGame.raceSingleRound();

        // then
        for (Car car : racingGame.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("자동차_목록_반환_테스트")
    void testGetCars() {
        // when
        List<Car> cars = racingGame.getCars();

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getCars()).isEqualTo("MAY");
    }

    @Test
    @DisplayName("우승자_반환_테스트")
    void testGetWinners() {
        // given
        Car car1 = new Car("MAY");
        car1.move(3);
        Car car2 = new Car("JUN");
        car2.move(5);
        List<Car> cars = Arrays.asList(car1, car2);
        racingGame = new RacingGame(cars, mockedRandom);

        // when
        List<String> winners = racingGame.getWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo("JUN");
    }

    @Test
    @DisplayName("우승자가_없는_경우_테스트")
    void testGetWinnersWhenNoCars() {
        // given
        List<Car> cars = List.of();
        racingGame = new RacingGame(cars, mockedRandom);

        // when / then
        assertThatThrownBy(() -> racingGame.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("경주에 참가한 자동차가 없습니다.");
    }
}
