import model.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("Name");
    }

    @Test
    void createRacingCarTest() {
        assertThat(racingCar.getCarName()).isEqualTo("Name");
        assertThat(racingCar.getForwardCount()).isEqualTo(0);
    }

    @Test
    void moveSuccessTest() {
        racingCar.move(5);
        assertThat(racingCar.getForwardCount()).isEqualTo(1);
    }

    @Test
    void moveFailTest() {
        racingCar.move(2);
        assertThat(racingCar.getForwardCount()).isEqualTo(0);
    }
}
