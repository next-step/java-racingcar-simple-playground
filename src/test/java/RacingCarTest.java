import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("다같이 1등일 때")
    void AllWinnerTest() {
        String[] names = {"1등", "2등", "3등"};
        RacingCar game = new RacingCar(names, new FixedInt(5));

        game.playRound(4);

        assertThat(game.getWinner()).hasSize(3);
    }

    @Test
    @DisplayName("1명만 우승일 때")
    void WinnerOnlyOne() {
        Car[] cars = new Car[]{
            new Car("1등", new FixedInt(5)),
            new Car("2등", new FixedInt(3))
        };
        //1등 -> 5 이동성공, 2등 -> 3 이동 실패
        RacingCar game = new RacingCar(cars);

        game.playRound(4);

        assertThat(game.getWinner().get(0).name).isEqualTo("1등");
    }
}
