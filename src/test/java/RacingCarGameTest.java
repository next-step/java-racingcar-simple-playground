import domain.RacingCar;
import domain.RacingCarGame;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingCarGame Junit5 Test")
public class RacingCarGameTest {
    @DisplayName("RacingCarGame Constructor Test")
    @Test
    public void constructorTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {"Ferrari", "BMW", "HYUNDAI"},15, new CustomGenerator(1));
        assertThat(game1.getWinnersPosition()).isEqualTo(0);
    }

    @DisplayName("RacingCarGame getting Winners Test")
    @Test
    public void getWinnersTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {"Ferrari", "HYUNDAI"},3, new CustomGenerator(1));

        for(int i = 0; i<3 ; i++){
            game1.playTurn();
        }
        assertThat(game1.getWinners()).isEqualTo(List.of("Ferrari", "HYUNDAI"));
        assertThat(game1.getWinners()).isNotNull();
    }

    @DisplayName("RacingCarGame getting Winners Position Test")
    @Test
    public void getWinnersPositionTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {"Ferrari", "HYUNDAI"},3, new CustomGenerator(7));

        for(int i = 0; i<3 ; i++){
            game1.playTurn();
        }
        assertThat(game1.getWinnersPosition()).isEqualTo(3);
    }

    @DisplayName("throw exception when num of Cars is 0")
    @Test
    public void zeroCarTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {},3, new CustomGenerator(1));

        assertThatThrownBy(() -> {
            game1.playTurn();
        }).isInstanceOf(RuntimeException.class);
    }
}