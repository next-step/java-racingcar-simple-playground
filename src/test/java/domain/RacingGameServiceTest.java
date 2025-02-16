package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {
    private static RacingGameService racingGameService;
    private static Cars cars;
    private Random fixedRandom;

    @BeforeEach
    void setUp() {
        fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        racingGameService = new RacingGameService(fixedRandom);

        List<String> carNames = List.of("neo", "brie", "brown");
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
        //이동 전
        List<Integer> positionsBeforeMove = cars.getCars().stream()
                .map(Car::getPosition)
                .toList();

        racingGameService.moveCars();

        //이동 후
        List<Integer> positionsAfterMove = cars.getCars().stream()
                .map(Car::getPosition)
                .toList();

        assertThat(positionsAfterMove).isNotEqualTo(positionsBeforeMove);
    }

    @Test
    @DisplayName("최대 위치를 가진 자동차가 우승한다.")
    void shouldSelectWinnerByMaxPosition() {
        cars.getCars().get(0).setPosition(3);
        cars.getCars().get(1).setPosition(5);
        cars.getCars().get(2).setPosition(5);

        List<Car> winners = racingGameService.getWinner();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("brie", "brown");
    }

    @Test
    @DisplayName("우승자의 이름을 올바르게 반환한다.")
    void shouldReturnWinnerNamesCorrectly() {
        String winnerNames = racingGameService.findWinnerName();

        assertThat(winnerNames).contains("brie, brown");
    }

    @Test
    @DisplayName("자동차가 없을 경우 우승자 선정 시 0을 반환한다.")
    void shouldReturnZero_WhenNoCarsExist() {
        racingGameService.carList(List.of());

        int maxPosition = racingGameService.getMaxPosition();

        assertThat(maxPosition).isEqualTo(0);
    }
}