package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @Test
    void 우승자가_1명일_수_있다() {
        //given
        Car winner = new Car("win1");
        Car loser1 = new Car("lose1");
        Car loser2 = new Car("lose2");
        winner.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner, loser1, loser2));
        //when
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).containsExactlyInAnyOrder("win1");
    }

    @Test
    void 우승자가_여러_명일_수_있다() {
        //given
        Car winner1 = new Car("win1");
        Car winner2 = new Car("win2");
        Car loser1 = new Car("lose1");
        Car loser2 = new Car("lose2");
        winner1.moveForward(()->MOVABLE_NUMBER);
        winner2.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner1, winner2, loser1, loser2));
        //when
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).containsExactlyInAnyOrder("win1", "win2");
    }
}
