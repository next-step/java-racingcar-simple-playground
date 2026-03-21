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
        winner.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner, loser1, loser2));
        //when
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).containsExactlyInAnyOrder("winner1");
    }

    @Test
    @DisplayName("우승자 구하는 기능: 공동 우승자를 정상적으로 구하는지 확인")
    void get_MultiWinner() {
        //given
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser1 = new Car("loser1");
        Car loser2 = new Car("loser2");
        winner1.moveForward(()->MOVABLE_NUMBER);
        winner2.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner1, winner2, loser1, loser2));
        //when
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).containsExactlyInAnyOrder("winner1", "winner2");
    }
}
