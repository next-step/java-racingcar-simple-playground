package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("각 자동차들의 이름을 전달받아 정상적으로 자동차 객체가 생성된다.")
    void shouldCreateCar_whenInputCarsName() {
        // given
        String carNames = "pobi,jiyun,juno";
        Cars cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "jiyun", "juno");
    }
}
