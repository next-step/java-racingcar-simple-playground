package racingcar.model;

<<<<<<< HEAD
=======
import org.junit.jupiter.api.DisplayName;
>>>>>>> upstream/htdufhc-bit
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @Test
<<<<<<< HEAD
    void 우승자가_1명일_수_있다() {
        //given
        Car winner = new Car("win1");
        Car loser1 = new Car("lose1");
        Car loser2 = new Car("lose2");
=======
    @DisplayName("우승자 구하는 기능: 단독 우승자를 정상적으로 구하는지 확인")
    void get_SingleWinner() {
        //given
        Car winner = new Car("winner1");
        Car loser1 = new Car("loser1");
        Car loser2 = new Car("loser2");
>>>>>>> upstream/htdufhc-bit
        winner.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner, loser1, loser2));
        //when
<<<<<<< HEAD
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
=======
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
>>>>>>> upstream/htdufhc-bit
        winner1.moveForward(()->MOVABLE_NUMBER);
        winner2.moveForward(()->MOVABLE_NUMBER);
        loser1.moveForward(()->NON_MOVABLE_NUMBER);
        loser2.moveForward(()->NON_MOVABLE_NUMBER);

        Cars cars = new Cars(List.of(winner1, winner2, loser1, loser2));
        //when
<<<<<<< HEAD
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).containsExactlyInAnyOrder("win1", "win2");
=======
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("winner1", "winner2");
>>>>>>> upstream/htdufhc-bit
    }
}
