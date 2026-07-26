package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 이름 목록을 전달하면 Car 객체 리스트가 정상적으로 생성된다.")
    void createRacingCars() {
        // given
        List<String> carNames = List.of("CarA", "CarB", "CarC");

        // when
        RacingCars racingCars = new RacingCars(carNames);
        List<Car> carList = racingCars.getCarsList();

        // then
        assertThat(carList.get(0).getName()).isEqualTo("CarA");
        assertThat(carList.get(1).getName()).isEqualTo("CarB");
        assertThat(carList.get(2).getName()).isEqualTo("CarC");
    }
}
