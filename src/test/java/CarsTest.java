import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private List<Car> cars_Fixture;
    private Car movableA_Fixture;
    private Car movableB_Fixture;
    private Car notMovableC_Fixture;

    @BeforeEach
    public void setUp() {
        movableA_Fixture = new Car("A",new MovableNumberGenerator());
        movableB_Fixture = new Car("B",new MovableNumberGenerator());
        notMovableC_Fixture = new Car("C",new NotMovableNumberGenerator());

        cars_Fixture = new ArrayList<>();
        cars_Fixture.add(movableA_Fixture);
        cars_Fixture.add(movableB_Fixture);
        cars_Fixture.add(notMovableC_Fixture);
    }

    @Test void testCarsFrom() {
        Cars cars = Cars.from(cars_Fixture);

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("A");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("B");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("C");
    }

    @Test
    public void testCarsMove() {
        Cars cars = Cars.from(cars_Fixture);
        cars.move();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getDistance()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getDistance()).isEqualTo(0);
    }

    @Test
    public void testCarsGetMaxDistance() {
        Cars cars = Cars.from(cars_Fixture);

        cars.move();
        cars.move();

        assertThat(cars.getMaxDistance()).isEqualTo(2);
    }

    @Test
    public void testFindCarsInSamePosition() {
        Cars cars = Cars.from(cars_Fixture);

        cars.move();
        cars.move();

        Cars carsInSamePosition = cars.findCarsHasSamePosition(2);
        assertThat(carsInSamePosition.getCars()).containsOnly(movableA_Fixture, movableB_Fixture);
    }

}
