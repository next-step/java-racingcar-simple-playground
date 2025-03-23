import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void testCreateCars() {
        List<String> carNames = List.of("A", "B", "C");
        Cars cars = Cars.create(carNames, new MovableNumberGenerator() );

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("A");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("B");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("C");
    }

    @Test void testCarsFrom() {
        List<Car> carList = new ArrayList<>();
        Cars cars;

        carList.add(new Car("A", new MovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new MovableNumberGenerator()));

        cars = Cars.from(carList);

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("A");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("B");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("C");
    }

    @Test
    public void testCarsMove() {
        List<Car> carList = new ArrayList<>();
        Cars cars;

        carList.add(new Car("A", new MovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new NotMovableNumberGenerator()));

        cars = Cars.from(carList);
        cars.move();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getDistance()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getDistance()).isEqualTo(0);
    }

    @Test
    public void testCarsGetMaxDistance() {
        List<Car> carList = new ArrayList<>();
        Cars cars;

        carList.add(new Car("A", new NotMovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new NotMovableNumberGenerator()));

        cars = Cars.from(carList);

        cars.move();
        cars.move();

        assertThat(cars.getMaxDistance()).isEqualTo(2);
    }

    @Test
    public void testFindCarsInSamePosition() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", new NotMovableNumberGenerator()));
        carList.add(new Car("B", new MovableNumberGenerator()));
        carList.add(new Car("C", new MovableNumberGenerator()));

        Cars cars = Cars.from(carList);

        cars.move();
        cars.move();

        Cars carsInSamePosition = cars.findCarsHasSamePosition(2);
        assertThat(carsInSamePosition.getCars()).containsOnly(carList.get(1), carList.get(2));
    }

}
