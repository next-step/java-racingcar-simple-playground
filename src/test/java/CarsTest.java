import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import CarGame2.domain.model.Car;
import CarGame2.domain.model.Cars;
import CarGame2.domain.service.FixedGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("조건을 충족하는 자동차는 위치가 올바르게 변경되어야 한다")
    void 조건충족_자동차들_위치_업데이트() {
        FixedGenerator fixedGenerator = new FixedGenerator(4);
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
        FixedGenerator fixedGenerator = new FixedGenerator(3);
        Cars cars = new Cars(List.of("car1", "car2", "car3"));
        int initialPosition = cars.getCars().get(0).getPosition();
        cars.moveAll(fixedGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(initialPosition);
        }
    }

    @Test
    @DisplayName("GetMaxpostion 호출 시 올바른 최대 위치를 반환해야한다")
    void getMaxpostion은_최대위치를_반환한다() {
        Cars cars = new Cars(List.of("car1", "car2", "car3"));
        cars.getCars().get(0).move(2);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(3);

        assertThat(cars.getMaxPosition()).isEqualTo(5);
    }
}
