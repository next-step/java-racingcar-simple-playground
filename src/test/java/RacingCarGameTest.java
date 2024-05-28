import domain.RacingCar;
import domain.RacingCarGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingCarGame Junit5 Test")
public class RacingCarGameTest {
    @DisplayName("RacingCarGame Constructor Test")
    @Test
    public void constructorTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {"Ferrari", "BMW", "HYUNDAI"},15);
        assertThat(game1.getWinnersPosition()).isEqualTo(0);
    }

    @DisplayName("RacingCarGame getting Winners Test")
    @Test
    public void getWinnersTest() {
        RacingCarGame game1 = new RacingCarGame(new String[] {"Ferrari", "BMW", "HYUNDAI"},15);

        assertThatThrownBy(() -> {
            game1.playTurn();
        }).isInstanceOf(RuntimeException.class);

        for(int i = 0; i<3 ; i++){
            game1.playTurn();
        }

        assertThat(game1.getWinners()).isNotNull();
    }
}
