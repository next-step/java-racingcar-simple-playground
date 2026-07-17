package domain.game;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerFinderTest {

    @Test
    @DisplayName("단독 우승 테스트")
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
    @DisplayName("공동 우승 테스트")
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
    @DisplayName("자동차 이름 비어 있을 때 테스트")
    void return_empty_list_when_cars_are_empty() {
        List<String> winners = WinnerFinder.findWinners(List.of());

        assertThat(winners).isEmpty();
    }
}
