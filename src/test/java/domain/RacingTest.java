package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class RacingTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("round()가 실행되면 참가하는 자동차 각각의 위치가 변경되어야 한다.")
    void round_test() {
        MovingStrategy alwaysMoveForward = () -> true;
        Racing racing = new Racing(cars, alwaysMoveForward);

        int roundCount = 3;
        for (int i = 0; i < roundCount; i++) {
            racing.round();
        }

        //모든 자동차가 전진하도록 설정한 뒤 3번의 라운드를 돌림
        //즉, 모든 자동차의 위치가 3이어야 함
        for (Car car : racing.getCarList()) {
            assertEquals(3, car.getPosition());
        }
    }
}
