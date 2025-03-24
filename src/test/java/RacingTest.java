import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Cars;
import domain.Racing;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    public void testPlayRound() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", new NotMovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new MovableNumberGenerator()));

        Racing racing = new Racing(Cars.from(carList));
        racing.playRound();

        assertThat(carList.get(0).getDistance()).isEqualTo(0);
        assertThat(carList.get(1).getDistance()).isEqualTo(1);
        assertThat(carList.get(2).getDistance()).isEqualTo(1);
    }

    @Test
    public void testFindWinner() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", new NotMovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new MovableNumberGenerator()));

        Racing racing = new Racing(Cars.from(carList));
        racing.playRound();

        Cars winnerList = racing.findWinners();

        assertThat(winnerList.getCars()).containsOnly(carList.get(1), carList.get(2));
    }

}
