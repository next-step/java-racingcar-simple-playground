package MovingCarTest;

import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;


public class RacingGameTest {
    private RacingGame RacingGame;

    //랜덤 수 테스트는 어떻게 진행?
    // 1. seed 지정
    @Test
    @DisplayName("최대 위치 확인")
    void testGetMaxPosition() {
        // Arrange
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.move();  // 예시로 각 자동차들을 다른 위치로 이동시킴
        car2.move();
        car2.move();
        car3.move();
        car3.move();
        car3.move();


        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Act
        int maxPosition = RacingGame.getMaxPosition(); // 변수 이름 수정

        // Assert
        assertEquals(1, maxPosition);  // 예상되는 최대 위치는 1
    }

}
