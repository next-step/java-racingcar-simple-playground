import controller.Racing;
import controller.RandomNumberGenerator;
import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void CarTest() {
        NumberGenerator2 numberGenerator2 = new NumberGenerator2();
        Car car1 = new Car("A", 0, numberGenerator2);
        car1.moving();
        assertThat(car1.getDistance()).isEqualTo(0);

        NumberGenerator3 numberGenerator3 = new NumberGenerator3();
        Car car2 = new Car("B", 0, numberGenerator3);
        car2.moving();
        assertThat(car2.getDistance()).isEqualTo(1);
    }



    //오버라이딩 -> 랜덤값을 2로 지정
    private static class NumberGenerator2 extends RandomNumberGenerator {
        @Override
        public int createRandomNumber() {
            return 2;
        }
    }

    //오버라이딩 -> 랜덤값을 7로 지정
    private static class NumberGenerator3 extends RandomNumberGenerator {
        @Override
        public int createRandomNumber() {
            return 7;
        }
    }


    @Test
    void findWinnerTest() {
        Racing racing = new Racing();
        ArrayList<String> names = new ArrayList<>();
        names.add("Car1");
        names.add("Car2");

        racing.initCars(names);
        for (int i = 0; i < 3; i++) {
            racing.eachRacing();
        }

        // 새로운 차량 추가 후 거리를 5로 설정
        racing.addCar("Car3", 5);

        List<String> winnersNames = racing.findWinners();

        Assertions.assertThat(winnersNames).containsExactly("Car3");
    }


    @Test
    void nameLengthTest() {
        Racing racing = new Racing();
        ArrayList<String> names = new ArrayList<>();
        names.add("TestTest"); // 5자를 초과하는 이름

        assertThatThrownBy(() -> racing.racing(1, 1, names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없으며, 5자를 초과할 수 없습니다.");
    }
}
