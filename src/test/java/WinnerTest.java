import domain.Car;
import domain.WinnerFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    @DisplayName("우승자가 한명일 때 찾기")
    void findSingleWinner() {
        List<Car> cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        cars.get(0).move(5);
        cars.get(1).move(2);
        cars.get(2).move(2);

        WinnerFinder finder = new WinnerFinder();
        String winnerNames = finder.findWinners(cars).toString();
        assertThat(winnerNames).isEqualTo("A");
    }

    @Test
    @DisplayName("우승자가 두명 이상일 때 찾기")
    void findMultipleWinners() {
        List<Car> cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(2).move(2);

        WinnerFinder finder = new WinnerFinder();
        String winnerNames = finder.findWinners(cars).toString();
        assertThat(winnerNames).isEqualTo("A, B");
    }
}
