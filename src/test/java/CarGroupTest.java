import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fixture.FixedNumberProvider;

public class CarGroupTest {

    @Test
    @DisplayName("positive - 자동차 그룹이 올바르게 이동한다.")
    void moveCars() {
        List<Car> cars = List.of(new Car("차"), new Car("차차"), new Car("차차차"));
        CarGroup carGroup = new CarGroup(cars, new FixedNumberProvider.Number4Provider());
        carGroup.moveCars();
        assertThat(cars).allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("positive - 가장 멀리 간 자동차를 반환한다.")
    void getFarthestCars() {
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        Car car3 = new Car("C");
        car1.move(new FixedNumberProvider.Number4Provider()); // 1칸 이동
        car2.move(new FixedNumberProvider.Number4Provider()); // 1칸 이동
        car3.move(new FixedNumberProvider.Number3Provider()); // 이동 X

        List<Car> cars = List.of(car1, car2, car3);
        CarGroup carGroup = new CarGroup(cars, new FixedNumberProvider.Number4Provider());
        List<Car> farthestCars = carGroup.getFarthestCars();

        assertThat(farthestCars).containsExactlyInAnyOrder(car1, car2);
    }
}
