package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        String inputNames = "haeun, minji, god";
        String [] carNames = inputNames.split(", ");

        RacingGame racingGame = new RacingGame(carNames,5);

        List<Car> cars = racingGame.getCars();

        assertThat(cars).hasSize(3);
    }

    @Test
    void move_값이_4이상이면_전진한다() {
        Car car = new Car("람보르기니");
        car.move(5);
        assertThat(1).isEqualTo(car.getPosition());

        car.move(9);
        assertThat(2).isEqualTo(car.getPosition());
    }
}
