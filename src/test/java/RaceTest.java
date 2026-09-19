import domain.Car;
import domain.Cars;
import domain.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class RaceTest {
    @Test
    @DisplayName("한 라운드 진행 시 자동차가 이동한다.")
    void oneRound() {
        Cars cars = new Cars(List.of("가"), new FixedMovement(new int[]{4}));
        Race race = new Race(cars);

        race.oneRound();

        assertThat(cars.findMaximum()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자가 한 명일 때 반환한다.")
    void returnOneWinner() {
        Cars cars = new Cars(List.of("A", "B", "C", "D","E"),
                new FixedMovement(new int[]{3, 2, 6, 2, 3}));
        cars.moveAll();

        Race race = new Race(cars);
        List<Car> winners = race.findWinners();
        assertThat(winners).extracting(Car::getName).containsExactly("C");
    }

    @Test
    @DisplayName("우승자가 한 명 이상일 때 반환한다.")
    void returnWinners() {
        Cars cars = new Cars(List.of("A","B","C","D","E"),
                new FixedMovement(new int[]{3, 5, 5, 2, 5}));
        cars.moveAll();

        Race race = new Race(cars);
        List<Car> winners = race.findWinners();
        assertThat(winners).extracting(Car::getName).containsExactly("B", "C", "E");
    }
}
