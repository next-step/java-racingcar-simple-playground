package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameServiceTest {
    private RacingGameService racingGameService;
    private Cars cars;
    private NumberGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = () -> 5;
        List<String> carNames = List.of("neo", "brie", "brown");
        racingGameService = new RacingGameService(randomGenerator);
        racingGameService.carList(carNames);
        cars = racingGameService.getCars();
    }

    @Test
    @DisplayName("자동차 리스트를 반환한다.")
    void returnCarList() {
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).extracting(Car::getName).containsExactly("neo", "brie", "brown");
    }

    @Test
    @DisplayName("자동차가 이동할 수 있어야 한다.")
    void shouldMoveCarForward() {
        // 이동 전
        List<Integer> positionsBeforeMove = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .toList();

        racingGameService.moveCars();

        // 이동 후
        List<Integer> positionsAfterMove = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .toList();

        assertThat(positionsAfterMove).isNotEqualTo(positionsBeforeMove);
    }

    @Test
    @DisplayName("최대 위치를 가진 자동차가 우승한다.")
    void shouldSelectWinnerByMaxPosition() {
        cars.getCars().get(0).move(3);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(5);

        racingGameService.moveCars();
        List<Car> winners = racingGameService.getWinner();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("brie", "brown");
    }

    @Test
    @DisplayName("우승자의 이름을 올바르게 반환한다.")
    void shouldReturnWinnerNamesCorrectly() {
        cars.getCars().get(0).move(3);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(5);

        racingGameService.moveCars();
        String winnerNames = racingGameService.findWinnerName();

        assertThat(winnerNames).contains("brie, brown");
    }

    @Test
    @DisplayName("자동차 리스트가 빈 리스트일 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenCarListIsEmpty() {
        assertThatThrownBy(() -> racingGameService.carList(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 리스트가 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenCarIsEmpty() {
        List<String> carNames = List.of("neo", " ", "brown");

        assertThatThrownBy(() -> racingGameService.carList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
}
