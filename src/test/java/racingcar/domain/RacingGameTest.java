package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임에 자동차를 추가하면, 자동차 목록에서 확인할 수 있다")
    void addCar_To_RacingGame() {
        // given
        RacingGame racingGame = new RacingGame(5, 3);

        // when
        racingGame.addCar("Car1");
        racingGame.addCar("Car2");
        racingGame.addCar("Car3");

        // then
        List<Car> cars = racingGame.getCarList();
        assertThat(cars).hasSize(3); // 3대의 차가 추가되었는지 확인
        assertThat(cars.get(0).getName()).isEqualTo("Car1");
        assertThat(cars.get(1).getName()).isEqualTo("Car2");
        assertThat(cars.get(2).getName()).isEqualTo("Car3");
    }
}
