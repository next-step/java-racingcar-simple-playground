import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("4이상의 값이 들어왔을때 자동차가 전진하는지 확인한다")
    void testCarMoves() {
        Car car1 = new Car("포르쉐", () -> 4);
        Car car2 = new Car("람보르기니", () -> 9);

        car1.move();
        car2.move();

        assertThat(car1.getTotalMoveCount()).isEqualTo(1);
        assertThat(car2.getTotalMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하의 값이 들어왔을때 자동차가 전진하지 않는지 확인한다")
    void testCarStops() {
        Car car1 = new Car("포르쉐", () -> 3);
        Car car2 = new Car("람보르기니", () -> 1);

        car1.move();
        car2.move();

        assertThat(car1.getTotalMoveCount()).isEqualTo(0);
        assertThat(car2.getTotalMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 총 전진 횟수를 정확하게 저장하는지 테스트")
    void testGetTotalMoveCount() {
        Car car1 = new Car("포르쉐", () -> 4);

        int testMoveCount = 10;
        for(int i = 0 ; i < testMoveCount; i++) {
            car1.move();
        }
        assertThat(car1.getTotalMoveCount()).isEqualTo(10);
    }
}
