import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void movesWhenNumberIsFourOrMore() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("peter");
        Car car3 = new Car("jason");
        Car[] cars = { car1, car2, car3 };

        FindWinner winnerFinder = new FindWinner(cars);
        winnerFinder.startRacing();
        winnerFinder.FindLongestPosition();

        assertThat(winnerFinder.FindWinnerName()).containsExactlyInAnyOrder("pobi"); // 우승자를 정확히 어떻게 뽑는지?
    }
}