import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        cars = new Cars(List.of(car1, car2, car3));
        RacingGame racingGame = new RacingGame(cars, 3);
    }

    @Test
    @DisplayName("우승자가 한 명 이상일 경우 모두 출력한다")
    void getWinners() {
        assertThat(cars.getWinners()).hasSize(3);
    }
}