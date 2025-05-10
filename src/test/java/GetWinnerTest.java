import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class GetWinnerTest {

    @Test
    @DisplayName("우승자를 한 대 판단")
    void single_winner() {
        Car car1 = new Car("neo");
        Car car2 = new Car("brie");
        Car car3 = new Car("brown");

        car1.move(1);
        car2.move(5);
        car3.move(2);

        List<Car> winners = new GetWinner().decideWinner(List.of(car1, car2, car3));

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("brie");
    }

    @Test
    @DisplayName("가장 멀리 간 차가 여러대일 경우 우승자를 여러명으로 판단")
    void multiple_winner() {
        Car car1 = new Car("neo");
        Car car2 = new Car("brie");
        Car car3 = new Car("brown");

        car1.move(5);
        car2.move(5);
        car3.move(3);

        List<Car> winners = new GetWinner().decideWinner(List.of(car1, car2, car3));

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("neo", "brie");
    }
}
