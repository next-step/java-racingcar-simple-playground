package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("중복된 이름의 자동차가 포함되어 있으면 예외가 발생한다.")
    void validateDuplicate_ThrowsException() {
        List<Car> carList = CarParser.parse("pobi,pobi,woni");

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 자동차 이름이 존재합니다.");
    }

    @Test
    @DisplayName("정상적인 자동차 리스트가 주어지면 Cars 객체가 생성된다.")
    void createCars_Success() {
        List<Car> carList = CarParser.parse("pobi,woni,jun");

        Cars cars = new Cars(carList);

        assertThat(cars.getCarList()).hasSize(3);
    }

    @Test
    @DisplayName("getCarList로 반환된 리스트는 불변(Immutable)이어야 한다.")
    void getCarList_IsImmutable() {
        List<Car> carList = CarParser.parse("pobi,woni");
        Cars cars = new Cars(carList);

        List<Car> returnedList = cars.getCarList();

        assertThatThrownBy(() -> returnedList.add(new Car("jun")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
