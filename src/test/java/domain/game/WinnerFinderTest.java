package domain.game;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerFinderTest {

    @Test
    @DisplayName("자동차 중 가장 멀리 이동한 자동차가 하나이면 해당 자동차 이름을 반환한다")
    void find_single_winner() {
        List<Car> cars = List.of(
                new Car("white", 3),
                new Car("blue", 1),
                new Car("red", 2)
        );

        List<String> winners = WinnerFinder.findWinners(cars);

        assertThat(winners).containsExactly("white");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대이면 모든 우승자 이름을 반환한다")
    void find_multiple_winners() {
        List<Car> cars = List.of(
                new Car("white", 3),
                new Car("blue", 3),
                new Car("red", 2)
        );

        List<String> winners = WinnerFinder.findWinners(cars);

        assertThat(winners).containsExactly("white", "blue");
    }

    @Test
    @DisplayName("자동차 목록이 비어 있으면 빈 우승자 목록을 반환한다")
    void return_empty_list_when_cars_are_empty() {
        List<String> winners = WinnerFinder.findWinners(List.of());

        assertThat(winners).isEmpty();
    }
}
