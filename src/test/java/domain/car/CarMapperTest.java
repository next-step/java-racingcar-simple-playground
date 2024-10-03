package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMapperTest {

    @Test
    @DisplayName("입력된 문자열을 자동차 목록으로 변환한다.")
    public void testTransformCarsNameListToCars() {

        String carsNameInput = "gold,ruka,dak";

        Cars cars = CarMapper.transformCarsNameListToCars(carsNameInput);
        List<Car> carList = cars.getCars();

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getCarName()).isEqualTo("gold");
        assertThat(carList.get(1).getCarName()).isEqualTo("ruka");
        assertThat(carList.get(2).getCarName()).isEqualTo("dak");

    }

}
