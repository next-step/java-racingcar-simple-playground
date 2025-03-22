import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import controller.RacingController;
import domain.Car;
import domain.Cars;
import domain.Racing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    private static final int MOVE_POSITION = 3;
    private static final int NOT_MOVE_POSITION = 0;

    @Test
    public void testPlayRace() {
        RacingController racingController = new RacingController();
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", new MovableNumberGenerator()));
        carList.add(new Car("B", new NotMovableNumberGenerator()));
        carList.add(new Car("C", new MovableNumberGenerator()));

        Cars cars = Cars.of(carList);
        Racing racing = new Racing(cars);

        racingController.playRace(racing, cars, MOVE_POSITION);

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(MOVE_POSITION);
        assertThat(cars.getCars().get(1).getDistance()).isEqualTo(NOT_MOVE_POSITION);
        assertThat(cars.getCars().get(2).getDistance()).isEqualTo(MOVE_POSITION);
    }

    @Test
    public void checkNameLengths () {
        RacingController racingController = new RacingController();
        List<String> names = Arrays.asList("Name", "TooLongName");

        assertThatThrownBy(() -> racingController.checkCarNameLengths(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
