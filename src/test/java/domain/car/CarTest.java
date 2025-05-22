package domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import domain.strategy.AlwaysMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있는지 테스트한다")
    void can_set_carName_each_car() {
        //Given
        Car fastCar = new Car("빠른차", new AlwaysMoveStrategy(), 0);
        Car slowCar = new Car("느린차", new AlwaysMoveStrategy(), 0);

        //When
        String carName1 = fastCar.getCarName();
        String carName2 = slowCar.getCarName();

        //Then
        assertThat(carName1).isEqualTo("빠른차");
        assertThat(carName2).isEqualTo("느린차");
    }
}
