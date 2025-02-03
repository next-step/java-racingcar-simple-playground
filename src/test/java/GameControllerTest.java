import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 관련 테스트 클래스")
public class GameControllerTest {
    @Test
    @DisplayName("자동차 참여가 정상적으로 되는가")
    public void testCarJoin() {
        GameController gc = new GameController();

        Car car1 = new Car("Kim");
        Car car2 = new Car("Lee");
        Car car3 = new Car("Park");

        gc.join(car1);
        gc.join(car2);
        gc.join(car3);

        List<Car> carList = gc.getCarList();

        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("단독 우승자가 정상적으로 구해지는가")
    public void testGetSoloWinners() {
        GameController gc = new GameController();

        Car car1 = new Car("Kim");
        Car car2 = new Car("Lee");
        Car car3 = new Car("Park");

        gc.join(car1);
        gc.join(car2);
        gc.join(car3);

        List<Car> carList = gc.getCarList();

        carList.get(1).move(4);

        List<Car> expected = new ArrayList<>();
        expected.add(car2);

        assertThat(gc.getWinners())
                .extracting(Car::getName)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("공동 우승자가 정상적으로 구해지는가")
    public void testGetSameWinners() {
        GameController gc = new GameController();

        Car car1 = new Car("Kim");
        Car car2 = new Car("Lee");
        Car car3 = new Car("Park");

        gc.join(car1);
        gc.join(car2);
        gc.join(car3);

        List<Car> carList = gc.getCarList();

        assertThat(gc.getWinners())
                .containsExactlyInAnyOrder(car1, car2, car3);
    }
}
