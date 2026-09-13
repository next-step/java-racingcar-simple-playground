import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FindWinnersTest {
    public void moveTimes(Car car, int times){
        for (int i = 0; i < times; i++) {
            car.move(true);
        }
    }

    @Test
    void 우승자가_1명일때_출력한다() {
        Car car1 = new Car("A");
        Car car2 = new Car("BC");
        Car car3 = new Car("DEF");

        moveTimes(car1, 3);
        moveTimes(car2, 5);
        moveTimes(car3,4);

        List<Car> cars = List.of(car1, car2, car3);
        Winner winner = new Winner();

        List<String> winners = winner.findWinners(cars);
        assertThat(winners).isEqualTo(List.of("BC"));
    };

    @Test
    void 우승자가_여러명일때_출력한다() {
        Car car1 = new Car("A");
        Car car2 = new Car("BC");
        Car car3 = new Car("DEF");
        Car car4 = new Car("GHIJ");

        moveTimes(car1, 3);
        moveTimes(car2, 5);
        moveTimes(car3, 4);
        moveTimes(car4, 5);

        List<Car> cars = List.of(car1, car2, car3, car4);
        Winner winner = new Winner();

        List<String> winners = winner.findWinners(cars);
        assertThat(winners).isEqualTo(List.of("BC", "GHIJ"));
    }
}
