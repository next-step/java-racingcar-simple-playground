import domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingCar Junit5 Test")
public class RacingCarTest {
    @DisplayName("RacingCar Constructor Test")
    @Test
    public void constructorTest() {
        RacingCar car1 = new RacingCar("Ferrari");
        assertThat(car1.getName()).isEqualTo("Ferrari");
    }

    @DisplayName("RacingCar moving Test")
    @Test
    public void moveTest() {
        RacingCar car1 = new RacingCar("Ferrari");
        assertThat(car1.move()).isEqualTo(car1.getPosition());
    }

    @DisplayName("RacingCar Random Number Generatißon Test")
    @Test
    public void randomNumberGenerationTest() {
        RacingCar car1 = new RacingCar("Ferrari");
        int num = car1.generateRamdomNum();
        assertThat(num).isBetween(0,9);
    }
}
