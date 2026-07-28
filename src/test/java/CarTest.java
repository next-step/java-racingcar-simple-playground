import domain.Car;
import domain.ExplicitMoveRule;
import domain.MoveRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car 테스트")
public class CarTest {

    @Test
    @DisplayName("숫자가 4 이상이면 이동")
    void moveIf4OrMore() {

        // 준비
        MoveRule explicitMoveRule1 = new ExplicitMoveRule(4);
        MoveRule explicitMoveRule2 = new ExplicitMoveRule(7);
        Car car1 = new Car("Player1");
        Car car2 = new Car("Player2");

        // 실행
        car1.move(explicitMoveRule1);
        car2.move(explicitMoveRule2);

        // 검증
        assertEquals(1, car1.getLocation());
        assertEquals(1, car2.getLocation());

    }

    @Test
    @DisplayName("숫자가 4 미만이면 이동 X")
    void notMoveIfLessThan4(){

        // 준비
        MoveRule explicitMoveRule1 = new ExplicitMoveRule(1);
        MoveRule explicitMoveRule2 = new ExplicitMoveRule(3);
        Car car1 = new Car("Player1");
        Car car2 = new Car("Player2");

        // 실행
        car1.move(explicitMoveRule1);
        car2.move(explicitMoveRule2);

        // 검증
        assertEquals(0, car1.getLocation());
        assertEquals(0, car2.getLocation());
    }
}
