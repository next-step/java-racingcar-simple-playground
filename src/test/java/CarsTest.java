import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import CarGame2.domain.model.Car;
import CarGame2.domain.model.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("조건을 충족하는 자동차는 위치가 올바르게 변경되어야 한다")
    void 조건충족_자동차들_위치_업데이트() {
        FixedNumberGenerator fixedGenerator = new FixedNumberGenerator(4);
        Cars cars = new Cars(List.of("car1", "car2", "car3"));
        int initialPosition = cars.getCars().get(0).getPosition();
        cars.moveAll(fixedGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(initialPosition + 4);
        }
    }

    @Test
    @DisplayName("조건을 충족하지 않는 자동차는 위치기 변하면 안된다")
    void 조건충족_안하는_자동차들은_정지() {
        FixedNumberGenerator fixedGenerator = new FixedNumberGenerator(3);
        Cars cars = new Cars(List.of("car1", "car2", "car3"));
        int initialPosition = cars.getCars().get(0).getPosition();
        cars.moveAll(fixedGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(initialPosition);
        }
    }
}
