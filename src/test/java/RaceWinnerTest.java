import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceWinnerTest {

    @DisplayName("우승자를 한 대 판단")
    @Test
    void single_winner() {
        Car car1 = new Car("A",2);
        Car car2 = new Car("B",5);
        Car car3 = new Car("C",0);

        GetWinner winner = new GetWinner();
        List<Car> winners = winner.decideWinner(List.of(car1, car2, car3));

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("B");
    }

    @DisplayName("가장 멀리 간 차가 여러대일 경우 우승자를 여러 대 판단")
    @Test
    void multiple_winners() {
        Car car1 = new Car("A",6);
        Car car2 = new Car("B",7);
        Car car3 = new Car("C",7);

        GetWinner winner = new GetWinner();
        List<Car> winners = winner.decideWinner(List.of(car1, car2, car3));

        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getName()).isEqualTo("B","C");
    }
}
