package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @Test
    @DisplayName("우승자 구하는 기능: 단독 우승자를 정상적으로 구하는지 확인")
    void get_SingleWinner() {
        //given
        Car winner = new Car("winner1");
        Car loser1 = new Car("loser1");
        Car loser2 = new Car("loser2");
        Cars cars = new Cars(List.of(winner, loser1, loser2));
        //when
        cars.moveCarAt(0, ()->MOVABLE_NUMBER);
        cars.moveCarAt(1, ()->NON_MOVABLE_NUMBER);
        cars.moveCarAt(2, ()->NON_MOVABLE_NUMBER);
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("winner1");
    }

    @Test
    @DisplayName("우승자 구하는 기능: 공동 우승자를 정상적으로 구하는지 확인")
    void get_MultiWinner() {
        //given
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser1 = new Car("loser1");
        Car loser2 = new Car("loser2");
        Cars cars = new Cars(List.of(winner1, winner2, loser1, loser2));
        //when
        cars.moveCarAt(0, ()->MOVABLE_NUMBER);
        cars.moveCarAt(1, ()->MOVABLE_NUMBER);
        cars.moveCarAt(2, ()->NON_MOVABLE_NUMBER);
        cars.moveCarAt(3, ()->NON_MOVABLE_NUMBER);
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("winner1", "winner2");
    }
}
