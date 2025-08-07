import model.Car;
import model.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    public void 단독_우승자_구하기_테스트() {
        Cars cars = new Cars();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        cars.join(car1);
        cars.join(car2);
        cars.join(car3);

        car1.move(4);

        List<Car> winners = cars.getWinners();

        assertThat(winners).isEqualTo(List.of(car1));
    }

    @Test
    public void 공동_우승자_구하기_테스트() {
        Cars cars = new Cars();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        cars.join(car1);
        cars.join(car2);
        cars.join(car3);

        List<Car> winners = cars.getWinners();

        assertThat(winners).isEqualTo(List.of(car1, car2, car3));
    }
}
