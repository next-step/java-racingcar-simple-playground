package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("RacingGame 객체가 정상적으로 생성된다.")
    void createRacingGame() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        List<Car> cars = List.of(car1, car2);
        int lapCount = 5;

        RacingGame racingGame = new RacingGame(cars, lapCount);

        assertThat(racingGame.getRacingCars()).hasSize(2);
        assertThat(racingGame.getLapCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("startLap을 실행하면..")
    void startLap_ReturnsCars() {   // todo
//        // given
//        Car car1 = new Car("Car1");
//        Car car2 = new Car("Car2");
//        List<Car> cars = List.of(car1, car2);
//        RacingGame racingGame = new RacingGame(cars, 5);
//
//        // when
//        List<Car> resultCars = racingGame.startLap();
//
//        // then

    }
}
