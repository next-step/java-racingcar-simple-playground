import domain.Car;
import domain.GeneratedFixedInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("다같이 1등일 때")
    void AllWinnerTest() {
        List<Car> cars = new ArrayList<>(
                List.of(new Car("1등", new GeneratedFixedInt(5))
                        , new Car("2등", new GeneratedFixedInt(4))
                        , new Car("3등", new GeneratedFixedInt(5))));
        RacingCars game = new RacingCars(cars);

        game.playRound(4);

        assertThat(game.getWinner()).hasSize(3);
    }

    @Test
    @DisplayName("1명만 우승일 때")
    void WinnerOnlyOne() {
        List<Car> cars = new ArrayList<>(
                List.of(new Car("1등", new GeneratedFixedInt(5))
                        , new Car("2등", new GeneratedFixedInt(3))));
        //1등 -> 5 이동성공, 2등 -> 3 이동 실패
        RacingCars game = new RacingCars(cars);
        game.playRound(1);

        assertThat(game.getWinner())
                .map(it -> it.getName())
                .containsExactlyInAnyOrder("1등");
    }
}
