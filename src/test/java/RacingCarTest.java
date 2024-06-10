import domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.CustomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCar Junit5 Test")
public class RacingCarTest {
    @DisplayName("RacingCar Constructor Test")
    @Test
    public void constructorTest() {
        RacingCar car1 = new RacingCar("Ferrari", new CustomGenerator(3));
        assertThat(car1.getName()).isEqualTo("Ferrari");
    }

    @ParameterizedTest
    @DisplayName("RacingCar moving Test")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTest(int value) {
        RacingCar car1 = new RacingCar("Ferrari", new CustomGenerator(value));
        assertThat(car1.move()).isEqualTo(car1.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("RacingCar not moving Test")
    public void stayTest(int value) {
        RacingCar car1 = new RacingCar("Ferrari", new CustomGenerator(value));
        assertThat(car1.move()).isEqualTo(car1.getPosition());
    }

}