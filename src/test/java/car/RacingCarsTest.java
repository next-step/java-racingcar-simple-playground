package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Test
    public void racingTest(){
        List<String> carNames = new ArrayList<>();
        carNames.add("carA");
        carNames.add("carB");
        carNames.add("carC");
        RacingCars racingCars = new RacingCars(carNames);

        List<Car> carList = racingCars.getCarList();
        Car carA = carList.get(0);
        Car carB = carList.get(1);
        Car carC = carList.get(2);

        carA.move(4);
        carB.move(3);
        carC.move(2);

        Car winner = racingCars.getWinner();

        assertThat(winner).isEqualTo(carA);

    }
}