import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 관련 테스트 클래스")
public class RacingGameTest {
    private RacingGame gc;
    private Car car1, car2, car3;

    @BeforeEach
    public void beforeEach() {
        gc = new RacingGame();

        car1 = new Car("Kim");
        car2 = new Car("Lee");
        car3 = new Car("Park");

        gc.join(car1);
        gc.join(car2);
        gc.join(car3);
    }

    @Test
    @DisplayName("자동차 참여가 정상적으로 되는가")
    public void testCarJoin() {
        assertThat(gc.getCarList()).hasSize(3);
    }

    @Test
    @DisplayName("단독 우승자가 정상적으로 구해지는가")
    public void testGetSoloWinners() {
        gc.getCarList().get(1).move(4);

        assertThat(gc.getWinners())
                .extracting(Car::getName)
                .containsExactly("Lee");
    }

    @Test
    @DisplayName("공동 우승자가 정상적으로 구해지는가")
    public void testGetSameWinners() {
        car1.move(9);
        car3.move(9);

        assertThat(gc.getWinners())
                .containsExactlyInAnyOrder(car1, car3);
    }
}
