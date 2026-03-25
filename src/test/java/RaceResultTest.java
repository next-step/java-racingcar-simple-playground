import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    @DisplayName("우승자 1명인 경우 올바르게 추출")
    public void Test_singlewinner() {
        Car car1 = new Car("A");
        car1.move(4);
        Car car2 = new Car("B");
        car2.move(0);
        RaceResult raceResult = new RaceResult(List.of(car1, car2));
        List<Car> winners = raceResult.getResult();
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("A");
    }

    @Test
    @DisplayName("공동우승자 추출")
    public void Test_multiwinners() {
        Car car1 = new Car("A");
        car1.move(4);
        Car car2 = new Car("B");
        car2.move(4);

        RaceResult raceResult = new RaceResult(List.of(car1, car2));
        List<Car> winners = raceResult.getResult();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("A", "B");
    }
}

